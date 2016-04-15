package org.tuui.order;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private final String QUEUE_NAME = "email.queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private CustomerClient customerClient;

	@Autowired
	private ProductClient productClient;

	@HystrixCommand(fallbackMethod = "sendEmailFallback")
	public String sendEmail(String email, String message) {
		Map map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("message", message);

		jmsTemplate.convertAndSend(QUEUE_NAME, map);
		
		return "sent e-mail using ActiveMQ";
	}
	
	private String sendEmailFallback(String email, String message){
		return "sent e-mail using alternative server";
	}

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
