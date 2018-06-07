package com.java.test.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Resource(name="sqlSession")
	SqlSession session;
	
	public List<HashMap<String, Object>> test5() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = session.selectList("test.select");
		return list;
	}
	
	public List<HashMap<String, Object>> selectList() {
		return session.selectList("test.selectList");
	}
	
	public HashMap<String, Object> selectOne(HashMap<String, Object> param){
		return session.selectOne("test.selectOne", param);
	}
	
	public int insert(HashMap<String, Object> param) {
		return session.insert("test.insert", param);
	}
	
	public int update(HashMap<String, Object> param) {
		return session.update("test.update", param);
	}
	
	public int delete(HashMap<String, Object> param) {
		return session.update("test.delete", param);
	}
	
}