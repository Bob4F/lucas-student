package github.lucas.redis.distributed.jedis.service;

import github.lucas.redis.distributed.jedis.RedisContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;

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

    private static final String LOCK_MSG = "OK";

    private static final Long UNLOCK_MSG = 1L;

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 加锁 一分钟内过期
     * @param key 锁的key
     * @param request 要设置的值
     * @return
     */
    public boolean tryLock(String key,String request){
        jedis = redisContent.jedisPool.getResource();
        String result = jedis.set("lock-"+key,request,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,10*60000);
        System.out.println(result);
        jedis.close();
        return false;
    }


    public boolean unlock(String key,String request){
            //lua script
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = null ;
            jedis = redisContent.jedisPool.getResource();
            if (jedis !=null){
                result = (jedis).eval(script, Collections.singletonList("lock-" + key), Collections.singletonList(request));
            }else {
                return false ;
            }
            System.out.println(result);
            if (UNLOCK_MSG.equals(result)){
                return true ;
            }
            System.out.println("解锁失败");
            return false;
    }

}
