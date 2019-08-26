package github.lucas.redis.distributed.lock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @author Lucas
 * @ClassName RedisString redis操作String 类
 * @Data 2019-08-26
 * @Version 1.0
 */
@Service
public class RedisString {
    @Autowired
    RedisService redisService;

    public void set(String key, Object value) {
        //更改在redis里面查看key编码问题
        RedisSerializer redisSerializer =new StringRedisSerializer();
        redisService.getRedisTemplate().setKeySerializer(redisSerializer);
        ValueOperations<String,Object> vo = redisService.getRedisTemplate().opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String,Object> vo = redisService.getRedisTemplate().opsForValue();
        return vo.get(key);
    }


}
