package com.chad.ademo.aop.inter;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NewWebLog {
	String desc() default "";
}
