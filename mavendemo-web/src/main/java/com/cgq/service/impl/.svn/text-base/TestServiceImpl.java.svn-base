/**
 * 
 */
package com.cgq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgq.mapper.test.TestMapper;
import com.cgq.model.TestRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author TZ
 *
 */
@Service
public class TestServiceImpl implements com.cgq.service.TestService {

	
	@Autowired
	private TestMapper testMapper;
	
	@Override
	public TestRecord queryByXMl(Integer arg) {
		
		return testMapper.selectById(arg);
	}

	@Override
	public int save(TestRecord record) {
		return testMapper.insert(record);
	}

	@Override
	public int testCount(Map<String, Object> params) {
		Example example = new Example(TestRecord.class);
		return testMapper.selectCountByExample(example);
	}

	@Override
	public PageInfo<TestRecord> testPage(Map<String, Object> params) {
		PageHelper.startPage(Integer.valueOf(params.get("pageNo").toString()), Integer.valueOf(params.get("pageSize").toString()));
		PageInfo<TestRecord> pageInfo = new PageInfo<>(testMapper.selectAll());
		return pageInfo;
	}

	@Override
	public int deleteById(Integer id) {
		return testMapper.deleteByPrimaryKey(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(TestRecord record) {
		Example example = new Example(TestRecord.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id",record.getId());
		return testMapper.updateByExample(record, example);
		
	}

	@Override
	public TestRecord queryById(Integer id) {
		Example record = new Example(TestRecord.class);
		Criteria criteria = record.createCriteria();
		criteria.andEqualTo("id", id);
		List<TestRecord> records =  testMapper.selectByExample(record);
		return records!=null?records.get(0):null;
	}

	@Override
	public TestRecord queryByName(String name) {
	
		Example record = new Example(TestRecord.class);
		Criteria criteria = record.createCriteria();
		criteria.andLike("name", "%"+name+"%");
		List<TestRecord> records =  testMapper.selectByExample(record);
		return records!=null?records.get(0):null;
		
	}

}
