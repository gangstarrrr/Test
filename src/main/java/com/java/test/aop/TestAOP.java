package com.java.test.aop;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TestAOP {
	
	@Autowired
	TestAOPInterface tai;
	
	@Pointcut("within(com.java.test..*)")
	private void pointcut() {}
	
	@Pointcut("bean(*Dao)")
	private void pointDao() {}
	
	@Before("pointDao()")
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
	@After("pointDao()")
	public void after(JoinPoint jp) {
		String name=jp.getSignature().toShortString();
		System.out.println(name+"종료 후!");
	}

	@Around("pointcut()")
	public Object callAOP(ProceedingJoinPoint joinPoint) throws Throwable {
			
		String name=joinPoint.getSignature().toShortString();
		System.out.println(name+"시작!");
		
		/******************************/
		if(name.contains("Controller")) {
			HashMap<String, Object> param=new HashMap<String, Object>();
			param.put("methodNm", joinPoint.getSignature().getName()); // 이름이 가져와진다
			Object[] args= joinPoint.getArgs();//오브젝트 배열로 리턴

			if(args[0] instanceof String) {
				param.put("menu",args[0]);}
			if(args[1] instanceof String) {
				param.put("type",args[1]);}
			

		tai.insert(param);
		/******************************/
		}
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
