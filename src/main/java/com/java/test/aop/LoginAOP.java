package com.java.test.aop;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.java.test.util.HttpUtil;

@Aspect
public class LoginAOP {

	@Around("within(com.java.test.user.UserController)")
	public Object loginCheck(ProceedingJoinPoint jp) throws Throwable{
		
		try {
			String name = jp.getSignature().getName();
			System.out.println(name+"호출 ㅇㅇ");
			
			/***********************************/
			
			Object[] args=jp.getArgs();
			for(int i=0;i<args.length;i++) {
				if(args[i] instanceof HttpServletRequest) {
					HttpServletRequest req=(HttpServletRequest)args[i];
					HashMap<String, Object> params=HttpUtil.getParamMap(req);
					
					String id=params.get("id").toString();
					String pwd=params.get("pwd").toString();
					
					boolean check=true;
					
					if(!"admin".equals(id)) {
						check=false;
					}
					if(!"1234".equals(pwd)) {
						check=false;					
					}
					if(check) {
						return jp.proceed();
					}else {
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("status", 0);
						map.put("msg", "누구세욤?");
						return HttpUtil.makeJsonView(map);
					}
				}
			}
			
			/***********************************/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
