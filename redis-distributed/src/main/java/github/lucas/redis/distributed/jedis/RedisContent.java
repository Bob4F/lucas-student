package github.lucas.redis.distributed.jedis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Lucas
 * @ClassName RedisTemplate
 * @Data 2019-09-16
 * @Version 1.0
 */
@Component
public class RedisContent {

    // 连接池
    public JedisPool jedisPool =null;

    /**
     * 无参：初始化参数
     */
    public RedisContent(){
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            // 允许最多创建多少个redis操作实例
            config.setMaxTotal(1024);
            // 允许空闲时 连接池中最多有多少个redis操作实例
            config.setMaxIdle(20);
            // 一个redis最大可用时间，过时销毁实例
            config.setMaxWaitMillis(10000*60);
            config.setTestOnBorrow(true);
            jedisPool = new JedisPool(config, "47.92.86.79", 6379, 10000, "sunfounder");
        } catch (Exception e){
            e.printStackTrace();
        }
    }




}
