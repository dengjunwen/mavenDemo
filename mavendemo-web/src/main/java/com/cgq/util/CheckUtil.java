package com.cgq.util;


import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil
{
    /**
     * 判断字符串为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(String str)
    {
        return null == str || str.trim().length()==0?true:false;
    }
    
    /**
     * 判断对象为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(Object obj)
    {
        return null == obj ? true : false;
    }
    
    /**
     * 判断数组为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(Object[] arr)
    {
    	
    	if(arr == null || arr.length<1){
    		return true;
    	}
        return false;
    }
    
    
    /**
     * 判断集合不为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean notEmpty(Collection c)
    {
        
        return !isEmpty(c);
    }
    /**
     * 判断对象不为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean notEmpty(Object c)
    {
        
        return !isEmpty(c);
    }
    
    /**
     * 判断数组不为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean notEmpty(Object[] c)
    {
        
        return !isEmpty(c);
    }
    /**
     * 判断Map不为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean notEmpty(Map c)
    {
        
        return !isEmpty(c);
    }
    
    /**
     * 判断字符串不为空
     * <一句话功能简述>
     * <功能详细描述>
     * @author zhangbin 
     * @date 2013-11-9 下午3:58:10 
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean notEmpty(String c)
    {
        return !isEmpty(c);
    }
    public static boolean isMobile(String str)
    {
        Pattern p = Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
//        Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public static boolean notMobile(String str)
    {
      
        return !isMobile(str);
    }
    
    private static boolean isLimitEmail(String email)
    {
        String[] emails = {"@163.com","@126.com","@sohu.com","@yeah.net","@gmail.com","@yahoo.cn","@qq.com","@sina.com.cn","@hotmail.com","@tom.cn","@live.cn"};
        for(String e : emails)
        {
            if(email.endsWith(e))
            {
                return true;
            }
        }
        return false;
    }
    public static  int getLength(String s)
    {
        s = s.replaceAll("[^\\x00-\\xff]", "**");
        int length = s.length();
        return length;
    }
    
    /**
     * 判断一个字符串是否是纯数字
     * @param str
     * @return
     */
    public static boolean isNumer(String str) {
		for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		}
		 return true;
	}
    
}