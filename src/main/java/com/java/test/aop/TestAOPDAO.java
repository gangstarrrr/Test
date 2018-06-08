package com.java.test.aop;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.test.temp.TestServiceinterface;

@Repository
public class TestAOPDAO implements TestAOPInterface {
	
	@Resource(name="sqlSession2")
	SqlSession session;
	
	@Override
	public int insert(HashMap<String, Object> param) {
		int status=session.insert("aop.insert",param);
		return status;
	}
	
}
