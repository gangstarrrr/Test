package com.java.test.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAOP {
	
	@Pointcut("within(com.java.test..*)")
	private void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		String name=jp.getSignature().toShortString();
		System.out.println(name+"시작 전 !");
		
		Object[] obj=jp.getArgs();
		System.out.println(name +" : "+obj.length);
		
		for(int i = 0;i<obj.length;i++) {
			if(obj[i] instanceof HashMap) {
				System.out.println("해쉬맵임 !");
				HashMap<String, Object> map=(HashMap<String, Object>) obj[i];
				for(String key:map.keySet()) {
					System.out.println(key+" : "+map.get(key));
				}
			}
		}
	}
	@After("pointcut()")
	public void after(JoinPoint jp) {
		String name=jp.getSignature().toShortString();
		System.out.println(name+"종료 후!");
	}

	@Around("pointcut()")
	public Object callAOP(ProceedingJoinPoint joinPoint) throws Throwable {
			
		String name=joinPoint.getSignature().toShortString();
		System.out.println(name+"시작!");
		long st=System.currentTimeMillis();
		
		try {
			Object obj=joinPoint.proceed();
			return obj;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			long et=System.currentTimeMillis();
			System.out.println(name+"종료!"+(et-st));
		}
		
		return null;
	}
}
