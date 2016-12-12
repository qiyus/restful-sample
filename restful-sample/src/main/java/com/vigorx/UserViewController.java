package com.vigorx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vigorx.business.User;

@RequestMapping(value = "/user")

@Controller
public class UserViewController {

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo(@ModelAttribute("user") User user) {
		return "user";
	}
}
