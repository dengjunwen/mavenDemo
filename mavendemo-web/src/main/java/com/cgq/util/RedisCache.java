package com.cgq.util;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCache {

	private static JedisPool pool;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] is not found!");
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.valueOf(bundle
				.getString("redis.pool.maxActive")));
		config.setMaxIdle(Integer.valueOf(bundle
				.getString("redis.pool.maxIdle")));
		config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config, bundle.getString("redis.ip"),
				Integer.valueOf(bundle.getString("redis.port")));
	}
	
	/**
	 * redis 取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		 	Jedis jedis = null;
		    String value = null;
		    try {
		    	System.out.println(pool);
		      jedis = pool.getResource();
		      value = jedis.get(key);
		    } catch (Exception e) {
		      pool.returnBrokenResource(jedis);
		      e.printStackTrace();
		    } finally {
		    	pool.returnResource(jedis);
		    }
		    return value;
	}
	
	
	public static String set(String key,String value){
	    Jedis jedis = null;
	    try {
	      jedis = pool.getResource();
	      return jedis.set(key, value);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	      return "0";
	    } finally {
	    	pool.returnResource(jedis);
	    }
	  }
	  
	  
	  /**
	   * <p>删除指定的key,也可以传入一个包含key的数组</p>
	   * @param keys 一个key  也可以使 string 数组
	   * @return 返回删除成功的个数 
	   */
	  public static Long del(String...keys){
	    Jedis jedis = null;
	    try {
	      jedis = pool.getResource();
	      return jedis.del(keys);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	      return 0L;
	    } finally {
	    	pool.returnResource(jedis);
	    }
	  }
	  
	  /**
	   * <p>通过key向指定的value值追加值</p>
	   * @param key 
	   * @param str 
	   * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度  异常返回0L
	   */
	  public static Long append(String key ,String str){
	    Jedis jedis = null;
	    Long res = null;
	    try {
	      jedis = pool.getResource();
	      res = jedis.append(key, str);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	      return 0L;
	    } finally {
	    	pool.returnResource(jedis);
	    }
	    return res;
	  }
	  
	  /**
	   * <p>判断key是否存在</p>
	   * @param key
	   * @return true OR false
	   */
	  public static Boolean exists(String key){
	    Jedis jedis = null;
	    try {
	      jedis = pool.getResource();
	      return jedis.exists(key);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	      return false;
	    } finally {
	    	pool.returnResource(jedis);
	    }
	  }
	  
	  /**
	   * <p>设置key value,如果key已经存在则返回0,nx==> not exist</p>
	   * @param key
	   * @param value
	   * @return 成功返回1 如果存在 和 发生异常 返回 0
	   */
	  public static Long setnx(String key ,String value){
	    Jedis jedis = null;
	    try {
	      jedis = pool.getResource();
	      return jedis.setnx(key, value);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	      return 0L;
	    } finally {
	    	pool.returnResource(jedis);
	    }
	  }
	  
	  /**
	   * <p>设置key value并制定这个键值的有效期</p>
	   * @param key
	   * @param value
	   * @param seconds 单位:秒
	   * @return 成功返回OK 失败和异常返回null
	   */
	  public static String setex(String key,String value,int seconds){
	    Jedis jedis = null;
	    String res = null;
	    try {
	      jedis = pool.getResource();
	      res = jedis.setex(key, seconds, value);
	    } catch (Exception e) {
	      pool.returnBrokenResource(jedis);
	      e.printStackTrace();
	    } finally {
	    	pool.returnResource(jedis);
	    }
	    return res;
	  }
	
	
	
	
	
}
