package com.spring.main.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("users/login")
    public String LoginUser(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "users/login";
    }
	
	

}
