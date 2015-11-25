package org.tuui.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderService {

	private static List<Order> orders = new ArrayList<>();

	static {
		orders.add(new Order(1L, 3L, 1L));
		orders.add(new Order(2L, 6L, 1L));
		orders.add(new Order(3L, 4L, 2L));
		orders.add(new Order(4L, 3L, 2L));
		orders.add(new Order(5L, 3L, 3L));
	}

	@Autowired
	private CustomerClient customerClient;

	@Autowired
	private ProductClient productClient;

	public Order getOrder(Long id) {
		Order order = orders.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);

		if (order != null) {
			try {
				CustomerClient.Customer customer = customerClient.getCustomer(order.getCustomerId());
				order.setCustomer(customer);
			} catch (Exception e) {
				log.error("Exception when loading customer:", e);
			}

			try {
				ProductClient.Product product = productClient.getProduct(order.getProductId());
				order.setProduct(product);
			} catch (Exception e) {
				log.error("Exception when loading product:", e);
			}
		}

		return order;
	}
}
