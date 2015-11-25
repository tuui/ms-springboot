package org.tuui.order;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		GuavaCache cache1 = new GuavaCache(CustomerClient.CUSTOMER_CACHE, CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS).build());
		GuavaCache cache2 = new GuavaCache(ProductClient.PRODUCT_CACHE, CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build());
		simpleCacheManager.setCaches(Arrays.asList(cache1, cache2));
		return simpleCacheManager;
	}
}
