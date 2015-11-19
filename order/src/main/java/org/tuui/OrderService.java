package org.tuui;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

	private static final String CUSTOMER_SERVICE_URI = "http://localhost:8091/customer/{id}";
	private static final String PRODUCT_SERVICE_URI = "http://localhost:8093/product/{id}";
	private static List<Order> orders = new ArrayList<>();

	static {
		orders.add(new Order(1L, 3L, 1L));
		orders.add(new Order(2L, 6L, 1L));
		orders.add(new Order(3L, 4L, 2L));
		orders.add(new Order(4L, 3L, 2L));
		orders.add(new Order(5L, 3L, 3L));
	}

	@Inject
	private RestTemplate restTemplate;

	public Order getOrder(Long id) {
		Order order = orders.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);

		if (order != null) {
			Customer customer = restTemplate.getForObject(CUSTOMER_SERVICE_URI, Customer.class, order.getCustomerId());
			order.setCustomer(customer);

			Product product = restTemplate.getForObject(PRODUCT_SERVICE_URI, Product.class, order.getProductId());
			order.setProduct(product);
		}

		return order;
	}
}
