package github.lucas.redis.distributed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDistributedLockApplicationTests {

	//@Autowired
	//RedisService redisService;

	@Autowired
	private StringRedisTemplate redisService;

	@Test
	public void testRedisSet(){
		String key = "spring-boot";
		String val = "start redis";
		redisService.opsForValue().set(key,val);
		String result = redisService.opsForValue().get(key);
		System.out.println(result);
	}


}
