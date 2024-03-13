package com.chushi.standard.i18n;

import com.chushi.standard.exception.BusinessException;

import java.util.Locale;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/13 下午 5:54
 * @Description 默认的统一返回结果国际化message组装实现
 * @ProjectName chushiy
 * @PackageName com.chushi.standard.pojo
 * @ClassName DefaultResultI18nMessageAssembler.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class DefaultResultI18nMessageAssembler implements ResultI18nMessageAssembler {
    @Override
    public String assembler(Locale language, BusinessException businessException) {
        return I18nMessageConfig.getI18nMessage(language, businessException.getMessage());
    }

    @Override
    public String assembler(Locale language, String originMessage) {
        return I18nMessageConfig.getI18nMessage(language, originMessage);
    }
}
