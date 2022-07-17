package kr.ac.btms.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageRootController {
	
	@RequestMapping({"/",""})
	public String index() {
		return "/management/main";
	}

}
