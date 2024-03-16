package com.chushi.standard.exception.support;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/16 下午 4:24
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushi.standard.exception.support
 * @ClassName DefaultModule.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class DefaultModule {

    /**
     * 采用单例
     * 默认模块
     */
    public static final ModuleSupport DEFAULT = new ModuleSupport() {
        @Override
        public String code() {
            return "0000";
        }

        @Override
        public String name() {
            return "default";
        }
    };

}
