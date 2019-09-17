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
	public void redisLock() throws InterruptedException {
		String key = "spring-boot";
		String val = "start redis2333333";
		lock.tryLock(key,val);
		System.out.println("上锁成功！");
		System.out.println("尝试解锁");
		StringBuffer stringBuffer =new StringBuffer("start redis23");
		while(true){
			boolean flag = lock.unlock(key,stringBuffer.toString());
			if (flag){
				break;
			}
			Thread.sleep(1000);
			stringBuffer = stringBuffer.append("3");
		}
		System.out.println("解锁成功");
	}

}
