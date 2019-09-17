package github.lucas.redis.distributed;

import github.lucas.redis.distributed.jedis.service.LockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDistributedLockApplicationTests {

	@Autowired
	private LockService lock;


	@Test
	public void tt(){
		String key = "spring-boot";
		String val = "start redis";
		lock.tryLock(key,val);
	}

}
