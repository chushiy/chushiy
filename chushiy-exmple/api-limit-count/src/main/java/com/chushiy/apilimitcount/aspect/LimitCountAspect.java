package com.chushiy.apilimitcount.aspect;

import com.chushiy.apilimitcount.annotation.LimitCount;
import com.chushiy.apilimitcount.util.IPUtils;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author 初时
 * @DateTime 2023/12/2 上午 1:04
 * @Description 接口限制次数切面
 * @ProjectName chushi
 * @PackageName com.chushi.apilimitcount.aspect
 * @ClassName LimitCountAspect.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class LimitCountAspect {

    private final RedisTemplate<String, Serializable> limitRedisTemplate;

    @Autowired
    public LimitCountAspect(RedisTemplate<String, Serializable> limitRedisTemplate) {
        this.limitRedisTemplate = limitRedisTemplate;
    }

    @Pointcut("@annotation(com.chushiy.apilimitcount.annotation.LimitCount)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LimitCount annotation = method.getAnnotation(LimitCount.class);
        // 注解名称
        String name = annotation.name();
        // 注解key
        String key = annotation.key();
        // 访问IP
        String ip = IPUtils.getIpAddr(request);
        // 过期时间
        int limitPeriod = annotation.period();
        // 过期次数
        int limitCount = annotation.count();

        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(annotation.prefix() + "_", key, ip));
        String luaScript = buildLuaScript();
        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
        Number count = limitRedisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
        log.info("IP:{} 第 {} 次访问key为 {}，描述为 [{}] 的接口", ip, count, keys, name);
        if (count != null && count.intValue() <= limitCount) {
            return point.proceed();
        } else {
            return "接口访问超出频率限制";
        }
    }

    /**
     * 限流脚本
     * 调用的时候不超过阈值，则直接返回并执行计算器自加。
     * 这段脚本有一个判断， tonumber(c) > tonumber(ARGV[1])这行表示如果当前key 的值大于了limitCount，直接返回；否则调用incr方法进行累加1，且调用expire方法设置过期时间
     *
     * @return lua脚本
     */
    private String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }

}
