/**
 * 
 */
package com.cgq.service;

import java.util.List;
import java.util.Map;

import com.cgq.model.TestRecord;
import com.github.pagehelper.PageInfo;

/**
 * @author TZ
 *
 */
public interface TestService {
	
	/**
	 * ���Ա���
	 * @param record
	 * @return
	 */
	public int save(TestRecord record);
	
	/**
	 * ����ɾ��
	 * @param id  
	 */
	public int deleteById(Integer id);
	
	/**
	 * ���Ը���
	 * @param record
	 */
	public int update(TestRecord record);
	/**
	 * ��ѯͨ��xml
	 * @param arg
	 * @return
	 */
	public TestRecord queryByXMl(Integer arg);
	
	/** ��ѯͨ��ͨ��mapper
	 * @param id
	 * @return
	 */
	public TestRecord queryById(Integer id);
	
	/**��ѯͨ����� like��ѯ
	 * @param name
	 * @return
	 */
	public TestRecord queryByName(String name);
	
	/**��ѯcount
	 * @param params
	 * @return
	 */
	public int testCount(Map<String, Object> params);
	
	/**��ҳ��ѯ
	 * @param params
	 * @return
	 */
	public PageInfo<TestRecord> testPage(Map<String, Object> params);

}
