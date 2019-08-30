package github.lucas.redis.distributed.lock.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Lucas
 * @ClassName RedisConfig
 * @Data 2019-08-26
 * @Version 1.0
 */
@Configuration
@EnableCaching//开启缓存
public class RedisConfig {

//    @Bean
//    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
//        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        return cacheManager;
//    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }







}
