package com.chad.ademo.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WebLogAspect {
	

	
	@Pointcut("@annotation(com.chad.ademo.aop.inter.WebLog)")
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
