package com.chushi.standard.exception.support;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/8 下午 7:01
 * @Description 错误支持 策略模式 提供扩展
 * @ProjectName chushi
 * @PackageName com.chushi.standard.exception.support
 * @ClassName ErrorSupport.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface ErrorSupport {

    /**
     * is系统错误
     * @return
     */
    boolean isSystemError();

    /**
     * 错误模块
     * @return
     */
    ModuleSupport module();

    /**
     * 错误code
     *  错误码为8位
     *  系统错误?1:0+模块code 4位+错误码 3位
     * @return
     */
    String getCode();
    /*default String getCode(){
        return (this.isSystemError()?0:1)+this.getModule().code()+this.
    }*/

    /**
     * 错误信息
     * @return
     */
    String getMessage();
}
