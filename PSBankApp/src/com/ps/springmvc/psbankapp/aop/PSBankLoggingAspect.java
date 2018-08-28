package com.ps.springmvc.psbankapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger; // JBoss Logger is required for creating the Logging
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PSBankLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	/************** Logging Block for The Controller Package starts here  ******************/
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.controllers.*.*(..))")
	private void forControllerPackage() { }
	
	/************** Logging Block for The Controller Package ends here  ******************/
	
	/************** Logging Block for The Services Package starts here  ******************/
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.services.*.*(..))")
	private void forServicesPackage() { }
	
	/************** Logging Block for The Services Package ends here  ******************/


	/************** Logging Block for The DAO Package starts here  ******************/
	
	@Pointcut("execution(* com.ps.springmvc.psbankapp.dao.*.*(..))")
	private void forDAOPackage() { }
	
	/************** Logging Block for The DAO Package ends here  ******************/

	@Pointcut("forControllerPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() { }
	
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Information: in @Before Advice: Calling the Method: " + methodName);
	}
	
	@AfterReturning(pointcut="forApplication()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Info: In @AfterReturnig: From Method: " + methodName);
		logger.info("Info: Data Returned by Method: " + result);
	}
}
