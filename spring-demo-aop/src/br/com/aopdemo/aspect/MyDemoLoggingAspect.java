package br.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void br.com.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(br.com.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))")
	@Before("execution(* br.com.aopdemo.dao.*.*(..))")
	public void beforeAddAccount() {
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
}
