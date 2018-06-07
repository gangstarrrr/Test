package com.java.test.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements TestServiceinterface {
	
	String type;
	
	@Autowired
	TestDao td;
		
	public void setType(String type) {
		this.type = type;
	}
	
	public void setTd(TestDao td) {
		this.td = td;
	}

	public String test() {
		return "test";
	}
	
	public HashMap<String, Object> test3() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if("select".equals(type)) {
			map.put("view", "test");
			map.put("data", "안녕하세요!");
		} else {
			map.put("view", "error");
		}
		return map;
	}
	
	public String test4() {
		System.out.println("test4");
		return "test";
	}
	
	public List<HashMap<String, Object>> test5() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = td.test5();
		return list;
	}
	
	HashMap<String, Object> result;
	
	public HashMap<String, Object> selectList(){
		result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = td.selectList(); // dao 실행
		result.put("result", list);
		return result;
	}
	public HashMap<String, Object> selectOne(HashMap<String, Object> param){
		result = new HashMap<String, Object>();
		HashMap<String, Object> map = td.selectOne(param); // dao 실행
		result.put("result", map);
		return result;
	}
	public HashMap<String, Object> insert(HashMap<String, Object> param){
		result = new HashMap<String, Object>();
		int cnt = td.insert(param); // dao 실행
		result.put("result", cnt);
		return result;
	}
	public HashMap<String, Object> update(HashMap<String, Object> param){
		result = new HashMap<String, Object>();
		int cnt = td.update(param); // dao 실행
		result.put("result", cnt);
		return result;
	}
	public HashMap<String, Object> delete(HashMap<String, Object> param){
		result = new HashMap<String, Object>();
		int cnt = td.delete(param); // dao 실행
		result.put("result", cnt);
		return result;
	}

	
}