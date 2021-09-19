package com.chad.aopdemo.aop.inter;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {
	
	String desc() default "";
}
