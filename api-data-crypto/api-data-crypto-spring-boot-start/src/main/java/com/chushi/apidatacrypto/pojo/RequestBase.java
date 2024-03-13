package com.chushi.apidatacrypto.pojo;

import com.chushi.standard.pojo.PO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 初时
 * @DateTime 2023/12/1 下午 7:38
 * @Description TODO
 * @ProjectName api-data-crypto
 * @PackageName com.chushi.apidatacrypto.pojo
 * @ClassName RequestBase.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RequestBase  extends PO {

    private Long currentTimeMillis;

}

