package org.tuui.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
			CustomerClient.Customer customer = customerClient.getCustomer(order.getCustomerId());
			order.setCustomer(customer);

			ProductClient.Product product = productClient.getProduct(order.getProductId());
			order.setProduct(product);
		}

		return order;
	}
}
