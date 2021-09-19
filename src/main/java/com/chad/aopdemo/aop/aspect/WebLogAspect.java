package com.chad.aopdemo.aop.aspect;


import com.chad.aopdemo.aop.inter.WebLog;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class WebLogAspect {
	

	
	@Pointcut("@annotation(com.chad.aopdemo.aop.inter.WebLog)")
	public void webLog() {
	}
	
	
	/**
	 * 环绕
	 *
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getTarget().getClass().toString();
		String methodName = pjp.getSignature().getName();
		log.info("调用前: " + className + ":" + methodName);
		Object proceed = pjp.proceed();
		log.info("调用后: " + className + ":" + methodName);
		return proceed;
	}
	
	
}
