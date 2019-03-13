package com.aop.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectAdvice {

	@Before("execution(* queryExecution(String*))")
	public void showMethodExecution(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		
		System.out.println("my mehtod has been called: " + args[0]);
	}
	
	@AfterThrowing("within(com.jdbc.EventService)")
	public void exceptionOccur(){
		System.out.println("exception occur");
	}
}
