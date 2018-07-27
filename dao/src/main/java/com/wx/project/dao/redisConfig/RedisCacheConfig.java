package com.wx.project.dao.redisConfig;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过spring管理redis缓存配置
 * 
 * @author ucmed
 * cgj
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	private volatile JedisConnectionFactory jedisConnectionFactory;

	private volatile RedisTemplate<String, Serializable> redisTemplate;

	private volatile RedisCacheManager redisCacheManager;

	public RedisCacheConfig() {
		super();
	}

	/**
	 * 带参数的构造方法 初始化所有的成员变量
	 *
	 * @param jedisConnectionFactory
	 * @param redisTemplate
	 * @param redisCacheManager
	 */
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory,
			RedisTemplate<String, Serializable> redisTemplate, RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}

	public JedisConnectionFactory getJedisConnecionFactory() {
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}

	public RedisTemplate<String, Serializable> getRedisTemplate() {
		return redisTemplate;
	}
    //设置缓存过期时间
	/*public RedisCacheManager getRedisCacheManager(String key) {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
		Map<String, Long> expires = new HashMap<String, Long>();
		expires.put(key, 1L);
		redisCacheManager.setExpires(expires);
		return redisCacheManager;
	}*/

	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory factory) {

		RedisTemplate<?, ?> template = new RedisTemplate<>();

		RedisSerializer<String> redisSerializer = new StringRedisSerializer();

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		template.setConnectionFactory(factory);
		// key序列化方式
		template.setKeySerializer(redisSerializer);
		// value序列化
		template.setValueSerializer(jackson2JsonRedisSerializer);
		// value hashmap序列化
		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		return template;
	}
}