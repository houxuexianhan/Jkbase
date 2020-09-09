package com.jack.jkbase.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Descrption该注解描述方法的操作类型和方法的参数意义
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Operation {
    /**
     * @Description描述操作类型   为必填项,1:登录日志2：操作日志
     */
    int type();
 
    /**
     * @Description描述操作意义   比如申报通过或者不通过等
     */
    String desc() default ""; 
 
    /**
     * @Description描述操作方法的参数意义 数组长度需与参数长度一致,否则会参数与描述不一致的情况
     */
    String[] arguDesc() default {};
}
