package kr.ac.btms.management.controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageRootController {
	private static final Logger logger = LoggerFactory.getLogger(manageRootController.class);

	@RequestMapping({"/main","/"})
	public String index() {
		return "/management/main";
	}
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "apitest/test3";
	}*/
}
