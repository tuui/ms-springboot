package org.tuui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable Long orderId){
		log.debug("getOrder orderId = {}", orderId);
		return orderService.getOrder(orderId);
	}
}
