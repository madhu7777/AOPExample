package com.example.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Aspect
@Component
public class AspectConfig {
	
//	@Before("execution(* com.example.aop.controller.*.*(..))")
//	public void before() {
//		System.out.println("Before Hello World");
//	}
	
	@Around("@annotation(com.example.aop.annotations.LogConfig)")
	public Object beforeAnnotation(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature sig = (MethodSignature)pjp.getSignature();
		System.out.println("Before Hello World" + sig.getMethod().getAnnotation(GetMapping.class).value().toString());
		return pjp.proceed();
	} 

}
