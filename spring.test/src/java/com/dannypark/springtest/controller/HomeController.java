package com.dannypark.springtest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dannypark.springtest.biz.dao.PotlUsrDao;
import com.dannypark.springtest.biz.model.BizTest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	PotlUsrDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		HashMap<String, Object> argMap = new HashMap<String, Object>();
		argMap.put("usrId", 1);
		List<Map<String, Object>> usrList = dao.selectPotlUsr(argMap);
		return "home";
	}
	
	public ModelAndView test() {
		BizTest a = new BizTest();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		ModelAndView mv = new ModelAndView("/home.jsp");
		mv.addObject("serverTime", formattedDate);		
		return mv;
	}
	
}
