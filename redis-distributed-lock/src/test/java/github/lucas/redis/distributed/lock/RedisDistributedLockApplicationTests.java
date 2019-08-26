package github.lucas.redis.distributed.lock;

import github.lucas.redis.distributed.lock.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDistributedLockApplicationTests {

	@Autowired
	RedisService service;

	@Test
	public void testRedisSet(){
		String key = "spring-boot";
		String val = "start redis";
		service.getRedisStrings().set(key,val);

		String result = (String) service.getRedisStrings().get(key);
		System.out.println(result);
	}


}
