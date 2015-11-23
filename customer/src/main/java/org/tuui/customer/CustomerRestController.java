package org.tuui.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		log.debug("getAllCustomers...");
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long customerId){
		log.debug("getCustomer customerId = {}", customerId);
		return customerService.getCustomer(customerId);
	}
}
