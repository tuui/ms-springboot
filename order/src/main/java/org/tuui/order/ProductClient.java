package org.tuui.order;


import lombok.Data;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

@FeignClient("product-service")
public interface ProductClient {

	@RequestMapping(method = RequestMethod.GET, value = "/product/{productId}")
	Product getProduct(@PathVariable("productId") Long productId);

	@Data
	class Product {
		private Long id;
		private String name;
		private BigDecimal price;
		private String description;
	}
	
}
