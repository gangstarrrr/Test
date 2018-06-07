package com.java.test.board;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.java.test.util.HttpUtil;

@Service
public class Board2Service implements Board2ServiceInterface{
	
	@Autowired
	BoardDaoInterface bdi;

	HashMap<String,Object> param;
	ModelAndView mav;
	
	@Override
	public ModelAndView board(String menu,String type, HttpServletRequest req) {
		
		mav=new ModelAndView();
		
		param=new HashMap<String, Object>();
		param.put("type", type);
		param.put("menu", menu);
		
		if("selectList".equals(type)) {
			mav.setViewName("boardList");
			
		}else if("selectOne".equals(type)) {
			param.put("param", HttpUtil.getParamMap(req));
			mav.setViewName("boardOne");
			
		}else if("insert".equals(type)) {
			param.put("param", HttpUtil.getParamMap(req));
			mav.setViewName("redirect:selectList");
			
		}else if("updateView".equals(type)) {
			param.put("type", "selectOne");
			param.put("param", HttpUtil.getParamMap(req));
			mav.setViewName("updateView");
			
		}else if("update".equals(type)) {
			param.put("param", HttpUtil.getParamMap(req));
			mav.setViewName("redirect:selectList");
			
		}else if("delete".equals(type)) {
			param.put("param", HttpUtil.getParamMap(req));
			mav.setViewName("redirect:selectList");
		}
		
		mav.addObject("data",bdi.board(param));
		
		return mav;
	}
	
	public ModelAndView json(String menu,String type, HttpServletRequest req) {
		
		param=new HashMap<String, Object>();
		param.put("type", type);
		param.put("menu", menu);
		
		if("updateView".equals(type)) {
			param.put("type", "selectOne");
		}
		
		HashMap<String,Object> map = HttpUtil.getParamMap(req);
		HashMap<String,Object> result = new HashMap<String, Object>();
		
		if(map==null) {
			System.out.println("null");
			result.put("status",0);
			result.put("msg","입력값이 없습니다.");

		}else {
			param.put("param", map);
			result = bdi.board(param);
			result.put("status",1);
		}
		
		return HttpUtil.makeJsonView(result);
	}
}
