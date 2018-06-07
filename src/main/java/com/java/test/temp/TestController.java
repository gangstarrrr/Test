package com.java.test.temp;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@Resource(name="testService")
	TestService ts;
	
	@RequestMapping("/test2")
	public String test2(String result) {
		result = ts.test();
		return result;
	}
	
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("result", ts.test3());
		return "test";
	}
	
	@RequestMapping("/test5")
	public String test5(Model model) {
		model.addAttribute("result", ts.test5());
		return "test";
	}
	
	HashMap<String, Object> param;
	
	@RequestMapping("/selectList")
	public String selectList(Model model) {
		model.addAttribute("data", ts.selectList());
		return "boardList";
	}
	
	@RequestMapping("/selectOne")
	public String selectOne(Model model, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("boardNo", req.getParameter("boardNo"));
		model.addAttribute("data", ts.selectOne(param));
		return "boardOne";
	}
	
	@RequestMapping("/insert")
	public String insert(Model model, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("title", req.getParameter("title"));
		param.put("content", req.getParameter("content"));
		param.put("regUser", Integer.parseInt(req.getParameter("regUser")));
		model.addAttribute("data", ts.insert(param));
		return "redirect:selectList";
	}
	
	@RequestMapping("/updateView")
	public String updateView(Model model, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("boardNo", req.getParameter("boardNo"));
		model.addAttribute("data", ts.selectOne(param));
		return "updateView";
	}	
	@RequestMapping("/update")
	public String update(Model model, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("title", req.getParameter("title"));
		param.put("content", req.getParameter("content"));
		param.put("boardNo", req.getParameter("boardNo"));
		model.addAttribute("data", ts.update(param));
		return "redirect:selectList";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("boardNo", req.getParameter("boardNo"));
		model.addAttribute("data", ts.delete(param));
		return "redirect:selectList";
	}
	
	
}