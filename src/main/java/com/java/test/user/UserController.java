package com.java.test.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.test.util.HttpUtil;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		//HttpUtil.makeJsonWriter(res, HttpUtil.getParamMap(req)); // 받고 바로 보낸거
		return HttpUtil.makeJsonView(HttpUtil.getParamMap(req));
	}
}
