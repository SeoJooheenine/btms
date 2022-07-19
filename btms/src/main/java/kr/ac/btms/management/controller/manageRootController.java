package kr.ac.btms.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class manageRootController {
	
	@RequestMapping({"/main","/"})
	public String index() {
		return "/management/main";
	}
}
