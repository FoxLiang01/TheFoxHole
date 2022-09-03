package com.ruoyi.extend.dbcolumn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加密字段
 * https://blog.csdn.net/qq_35387940/article/details/121374918
 *
 * @author Tellsea
 * @date 2022/9/3
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptField {

    String[] value() default "";
}