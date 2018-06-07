package com.java.test.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface Board2ServiceInterface {
	
	public ModelAndView board(String menu,String type, HttpServletRequest req);
	public ModelAndView json(String menu,String type, HttpServletRequest req);
}