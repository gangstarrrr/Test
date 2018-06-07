
package com.java.test.temp;

import java.util.HashMap;
import java.util.List;

public interface TestServiceinterface {
	public String test();
	public HashMap<String, Object> test3();
	public String test4();
	public List<HashMap<String, Object>> test5();
	
	public HashMap<String, Object> selectList();
	public HashMap<String, Object> selectOne(HashMap<String, Object> param);
	public HashMap<String, Object> insert(HashMap<String, Object> param);
	public HashMap<String, Object> update(HashMap<String, Object> param);
	public HashMap<String, Object> delete(HashMap<String, Object> param);
}
