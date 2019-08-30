package github.lucas.redis.distributed.lock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Lucas
 * @ClassName RedisService redisTemplate管理
 * @Data 2019-08-26
 * @Version 1.0
 */
@Component
public class RedisService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisString redisStrings;


    public RedisTemplate  getRedisTemplate(){
        return this.redisTemplate;
    };

    public RedisString  getRedisStrings(){
        return this.redisStrings;
    };


}
