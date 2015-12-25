package com.cgq.mapper.test;

import java.util.List;

import com.cgq.model.TestRecord;

import tk.mybatis.mapper.common.Mapper;

public interface TestMapper  extends Mapper<TestRecord>{
	
	
	
	
	public TestRecord selectById(Integer id);
	
	
	public List<TestRecord> queryList();

}
