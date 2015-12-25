/**
 * 
 */
package com.cgq.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgq.model.TestRecord;
import com.cgq.service.TestService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

/**
 * @author TZ
 *
 */
@Controller
public class TestController {
	
	
	Logger LOG = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;
	
	
	@ResponseBody
	@RequestMapping("/test/list")
	public Object list(Model model,Integer pageNo, Integer pageSize,HttpServletRequest request)
	{
		
		Map<String, Object> params = Maps.newConcurrentMap();
		pageNo = pageNo==null?1:pageNo;
		pageSize = pageSize==null?10:pageSize;
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		PageInfo pageInfo = testService.testPage(params);
		return pageInfo;
	}
	@RequestMapping("/test/queryByXml/{id}")
	@ResponseBody
	public Object detail(Model model,@PathVariable("id")Integer id,HttpServletRequest request)
	{
			return testService.queryByXMl(id);
		
	}
	@RequestMapping("/test/queryBy/{id}")
	@ResponseBody
	public  Object queryById(@PathVariable("id")Integer id){
		
		return testService.queryById(id);
		
	}
	
	@RequestMapping("/test/queryBy/name")
	@ResponseBody
	public Object queryByName(String name){
		
		
		return testService.queryByName(name);
	}
	
	
	@RequestMapping("/test/update")
	@ResponseBody
	public Object update(){
		
		TestRecord record = new TestRecord();
		record.setId(1);
		record.setName("11111-update");
//		record.setTime("11111-time");
		return testService.update(record);
	}
	
	
	
	@RequestMapping("/test/insert")
	@ResponseBody
	public Object insert(){
		TestRecord record = new TestRecord();
//		record.setId(1);
		record.setName("99999");
		record.setTime("99999");
		return testService.save(record);
		
	}

	@RequestMapping("/test/del/{id}")
	@ResponseBody
	public Object delete(@PathVariable("id")Integer id){
		return testService.deleteById(id);
	}
	
}
