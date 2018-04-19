package com.github.jettyrun.common.utils.validator;


import java.lang.annotation.*;

/**
 * Created by jetty on 18/2/12.
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlack {
    String value() default "";
}
