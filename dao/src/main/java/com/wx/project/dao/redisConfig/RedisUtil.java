package com.wx.project.dao.redisConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * cgj
 */
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	@Autowired
	private RedisCacheConfig redisCacheConfig;
	// hash put
	public void hashPut(String key, String filed, Serializable object) {
		redisTemplate.opsForHash().put(key, filed, object);
	}

	public void setMap(String key,Map object) {
		redisTemplate.opsForHash().putAll(key, object);
		redisTemplate.expire(key,1800,TimeUnit.SECONDS);
	}

	public Map getMap(String key) {
		Map M=redisTemplate.opsForHash().entries(key);
		return M;

	}

	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> hashGetAll(String key) {
		return (List)redisTemplate.opsForList().range(key,0,-1);
	}

	// delete
	public void delete(String key) {
		redisTemplate.delete(key);
	}
	public void setValue(String key ,String value) {
		 redisTemplate.opsForValue().set(key, value);
		 redisTemplate.expire(key, 60, TimeUnit.SECONDS);
	}
	public String getValue(String key) {
		return redisTemplate.opsForValue().get(key)+"";
	}
	// object get
	public Serializable putList(String key ,List list) {

		return redisTemplate.opsForList().leftPushAll(key,list);
	}

}

