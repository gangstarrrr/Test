package com.java.test;

import java.util.List;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.test.temp.TestService;

public class Main {
	
	public static void main(String[] args) {
		String config = "file:src/main/webapp/WEB-INF/spring/root-context.xml";        // xml 파일 경로
		AbstractApplicationContext ac = new GenericXmlApplicationContext(config); // 컨터이너를 생성
		
		/*****************************************************************************************************************************************
		 * Bean 사용 테스트
			TestService ts = ac.getBean("testService", TestService.class); // 컨테이너에 있는 bean를 가져와서 주입
		//	ts.type = "select"; // 초기값 설정
			String result = ts.test();  // bean 사용
			System.out.println(result);
			HashMap<String, Object>  result = ts.test3();
			System.out.println(result);
		 *****************************************************************************************************************************************/	

		/*****************************************************************************************************************************************
		 * DB 연결 테스트
		 *****************************************************************************************************************************************/
		 	SqlSessionTemplate session = ac.getBean("sqlSession", SqlSessionTemplate.class);
			List<HashMap<String, Object>> list = session.selectList("test.select");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}

}
}
