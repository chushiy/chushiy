package com.chushiy.standard.spi;

import com.chushiy.standard.i18n.ResultI18nMessageAssembler;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/13 下午 5:58
 * @Description 统一返回结果国际化message组装供应商
 * @ProjectName chushiy
 * @PackageName com.chushi.standard.i18n
 * @ClassName ResultI18nMessageAssemblerProvider.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class ResultI18nMessageAssemblerProvider {

    /**
     * 默认供应商的全限定名
     */
    private static final String DEFAULT_PROVIDER = "com.chushi.standard.i18n.DefaultResultI18nMessageAssembler";

    private static ResultI18nMessageAssembler resultI18nMessageAssembler;

    /**
     * 获取供应商
     *
     * @return ResultI18nMessageAssembler
     */
    public static ResultI18nMessageAssembler getProvider() {
        if (resultI18nMessageAssembler != null) {
            return resultI18nMessageAssembler;
        }
        synchronized (ResultI18nMessageAssemblerProvider.class) {
            if (resultI18nMessageAssembler != null) {
                return resultI18nMessageAssembler;
            }
            // region 使用Java SPI机制加载
            ServiceLoader<ResultI18nMessageAssembler> serviceLoader = ServiceLoader.load(ResultI18nMessageAssembler.class);
            Iterator<ResultI18nMessageAssembler> iterator = serviceLoader.iterator();
            if (iterator.hasNext()) {
                resultI18nMessageAssembler = iterator.next();
                return resultI18nMessageAssembler;
            }
            // endregion
            // region 如果Java SPI没有发现提供者则使用反射实例化默认的提供者
            try {
                Class<?> aClass = Class.forName(DEFAULT_PROVIDER);
                resultI18nMessageAssembler = (ResultI18nMessageAssembler) aClass.newInstance();
                return resultI18nMessageAssembler;
            } catch (Exception e) {
                throw new RuntimeException(String.format("ResultI18nMessageAssembler:%s无法被实例化", DEFAULT_PROVIDER), e);
            }
            // endregion
        }
    }
}
