package github.lucas.redis.distributed.jedis.service;

import github.lucas.redis.distributed.jedis.RedisContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author Lucas
 * @ClassName LockService
 * @Data 2019-09-17
 * @Version 1.0
 */
@Service
public class LockService {

    @Autowired
    RedisContent redisContent;

    private Jedis jedis=null;

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 加锁
     * @param key 锁的key
     * @param request 要设置的值
     * @return
     */
    public boolean tryLock(String key,String request){
        jedis = redisContent.jedisPool.getResource();
        String result = jedis.set("LOCK"+key,request,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,10*60);
        System.out.println(result);
        jedis.close();
        return false;
    }

}
