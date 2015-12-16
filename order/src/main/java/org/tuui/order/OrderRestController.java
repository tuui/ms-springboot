package org.tuui.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("order")
@RefreshScope
public class OrderRestController {

	private final String QUEUE_NAME = "email.queue";

	@Autowired
	private OrderService orderService;

	@Value("${app.test.value}")
	String test;

	@Value("${app.test.value2}")
	String test2;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testConf(){
		return test + " | " + test2;
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable Long orderId){
		log.debug("getOrder orderId = {}", orderId);
		return orderService.getOrder(orderId);
	}

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public void sendOrderTestMessage() {
		log.debug("sendOrderTestMessage...");
		orderService.sendEmail("test@gmail.com", "test e-mail");
	}
}
