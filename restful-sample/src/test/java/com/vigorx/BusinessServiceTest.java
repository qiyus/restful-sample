package com.vigorx;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/spring-mybatis.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class BusinessServiceTest {

	private MockMvc mockMvc;

	@Resource
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBusinessList() throws Exception {
		String url = "/smallenterprises/searchlist?q=广东&pageNum=1&pageSize=4";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andDo(print());
	}

	@Test
	public void testGetDetail() throws Exception {
		String url = "/smallenterprises/searchdetail?entNo=1&regOrg=5567";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andDo(print());
	}

	@Test
	public void testAddBusinessList() throws Exception {
		String url = "/smallenterprises/addBusiness";
		String json = "{\"entNo\":\"entNo\",\"entName\":\"entName\",\"code\":\"789\",\"entTypeStr\":\"entTypeStr\",\"registeredCapital\":\"dsfsdf\",\"regorg\":\"5454\",\"regorgStr\":\"ddd\"}";
		mockMvc.perform(
				post(url, "json").characterEncoding("UTF-8")
						.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testGetPathVariable() throws Exception {
		String url = "/smallenterprises/enterprise/detail";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andDo(print());
	}

	@Test
	public void testGetCookieVariable() throws Exception {
		String url = "/smallenterprises/cookie";
		Cookie cookies = new Cookie("token", "89ds9ko39023iou903290");
		mockMvc.perform(get(url, 1L).cookie(cookies)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andDo(print());
	}

	@Test
	public void testGetRequestHeader() throws Exception {
		String url = "/smallenterprises/header";
		mockMvc.perform(get(url, 1L).header("imei", "93902klkldf-83838"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andDo(print());
	}

	@Test
	public void testGetUser() throws Exception {
		String url = "/smallenterprises/user?name=songlei&password=123&age=18&dept.address=大连&dept.tel=98388383";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testAddUser() throws Exception {
		String url = "/smallenterprises/user";
		mockMvc.perform(
				post(url).characterEncoding("UTF-8").param("name", "wangli")
						.param("password", "ppp").param("age", "15")
						.param("dept.address", "xian").param("dept.tel", "10339993939"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testRequest() throws Exception {
		String url = "/smallenterprises/request?name=songlei&password=123&age=18&dept.address=大连&dept.tel=98388383";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testModelUser() throws Exception {
		String url = "/user/info?name=songlei&password=123&age=18&dept.address=大连&dept.tel=98388383";
		mockMvc.perform(get(url, 1L)).andExpect(status().isOk()).andDo(print());
	}
}
