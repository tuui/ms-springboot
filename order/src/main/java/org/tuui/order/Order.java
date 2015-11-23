package org.tuui.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Order {
	private Long id;
	@JsonIgnore
	private Long customerId;
	private CustomerClient.Customer customer;
	@JsonIgnore
	private Long productId;
	private ProductClient.Product product;

	public Order(Long id, Long customerId, Long productId) {
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
	}
}
