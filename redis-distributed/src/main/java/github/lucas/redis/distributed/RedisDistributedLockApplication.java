package github.lucas.redis.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RedisDistributedLockApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDistributedLockApplication.class, args);
	}

}
