package com.chushiy.apiaccesslimit.interceptor;

import com.chushiy.apiaccesslimit.annotation.AccessLimit;
import com.chushiy.apiaccesslimit.constant.AccessLimitConstant;
import com.chushiy.apiaccesslimit.exception.AccessLimitException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 11:45
 * @Description 访问限制功能拦截器
 * @ProjectName chushi
 * @PackageName com.chushi.apiaccesslimit.interceptor
 * @ClassName AccessLimitInterceptor.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class AccessLimitInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            // TODO 后续改进根据ip限制
            // 获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean isLogin = accessLimit.isLogin();
            long currentUserId = accessLimit.currentUserId();
            String key = request.getRequestURI();
            // 需要登录
            if (isLogin) {
                // 获取登录的session进行判断
                //.....
                key += "" + "1";  // 这里假设用户是1,项目中是动态获取的userId
            }

            // 从redis中获取用户访问的次数
            Long accessCount = Long.parseLong(this.redisTemplate.opsForValue().get(AccessLimitConstant.ACCESS_PREFIX_KEY + currentUserId));
            if (accessCount == null) {
                // 第一次访问
                this.redisTemplate.opsForValue().set(AccessLimitConstant.ACCESS_PREFIX_KEY + currentUserId, "1");
            } else if (accessCount < maxCount) {
                // 加1
                this.redisTemplate.opsForValue().increment(AccessLimitConstant.ACCESS_PREFIX_KEY + currentUserId, 1);
            } else {
                throw new AccessLimitException("访问次数过多，请稍后再试!");
            }
            return false;
        }
        return true;
    }
}
