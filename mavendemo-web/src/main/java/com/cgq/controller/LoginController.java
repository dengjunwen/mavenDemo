package com.cgq.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgq.util.ResultCode;
import com.google.common.collect.Maps;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/indexlogin")
	public String  list(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "login";
	}
	
	
	@RequestMapping("/manage/index")
	public String  index(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "index";
	}
	
	@RequestMapping("/syslogin")
	@ResponseBody
	public Map syslogin(String username,String password,Integer remeberMe,HttpServletRequest request){
		Map<String,Object> data = Maps.newHashMap();
		
		data.put("code", ResultCode.RESULT_CODE_SUCCESS);
		data.put("msg", ResultCode.RESULT_CODE_SUCCESS_MSG);
		return data;
		
	}
}
