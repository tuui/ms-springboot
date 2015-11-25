package org.tuui.order;


import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("customer-service")
public interface CustomerClient {

	String CUSTOMER_CACHE = "customer";

	@Cacheable(CUSTOMER_CACHE)
	@RequestMapping(method = RequestMethod.GET, value = "/customer/{customerId}")
	Customer getCustomer(@PathVariable("customerId") Long customerId);

	@Data
	class Customer {
		private Long id;
		private String name;
		private String email;
	}

}
