package com.vigorx.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import com.vigorx.Result;

@RestController
@RequestMapping(value = "/smallenterprises")
public class BusinessController {
	@Resource
	private BusinessService businessService;

	@RequestMapping(value = "/searchlist", method = RequestMethod.GET)
	public Result getBusinessList(@RequestParam(value = "q") String query,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		List<BusinessResult> businessList = businessService.getBusinessList(query,
				pageSize, (pageNum - 1) * pageSize);

		Result result = new Result();
		result.setResult(businessList);
		return result;
	}

	@RequestMapping(value = "/searchdetail", method = RequestMethod.GET)
	public Result getBusinessDetail(@RequestParam(value = "entNo") String entNo,
			@RequestParam(value = "regOrg") String regOrg) {
		BusinessDetailResult businessDetail = businessService.getBusinessDetail(entNo,
				regOrg);
		Result result = new Result();
		result.setResult(businessDetail);
		return result;
	}
	
	@RequestMapping(value = "/addBusiness", method = RequestMethod.POST)
	public Result addBusiness(@RequestBody BusinessResult Business){
		Result result = new Result();
		result.setResult(Business);
		return result;
	}
	
	@RequestMapping(value = "/{ent}/detail", method = RequestMethod.GET)
	public Result getEnterprise(@PathVariable("ent") String entName) {
		Result result = new Result();
		result.setResult(entName);
		return result;
	}

	@RequestMapping(value = "/cookie", method = RequestMethod.GET)
	public Result getCookie(@CookieValue("token") String token) {
		Result result = new Result();
		result.setResult(token);
		return result;
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public Result getIMEI(@RequestHeader("imei") String imei) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("imei", imei);
		Result result = new Result();
		result.setResult(m);
		return result;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Result getUser(User user) {
		Result result = new Result();
		result.setResult(user);
		return result;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Result addUser(User user) {
		Result result = new Result();
		result.setResult(user);
		return result;
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public void servletApi(HttpServletRequest request, HttpServletResponse response) {
		String name = WebUtils.findParameterValue(request, "name");
		response.addCookie(new Cookie("test", name));
	}
}
