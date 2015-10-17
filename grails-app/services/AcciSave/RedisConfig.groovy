package AcciSave

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

import redis.clients.jedis.JedisPoolConfig

@Configuration
public class RedisConfig {


	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig()
		poolConfig.setMaxTotal(128)
		poolConfig.setTestOnBorrow(true)
		poolConfig.setTestOnReturn(true)

		JedisConnectionFactory ob = new JedisConnectionFactory(poolConfig)
		ob.setUsePool(true)
		ob.setHostName("10.0.0.157")
		ob.setPort(6379)
		return ob
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		return new StringRedisTemplate(jedisConnectionFactory())
	}
}