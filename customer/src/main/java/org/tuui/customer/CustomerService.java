package org.tuui.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	static {
		customers.add(new Customer(1L, "Steve", "steva@gmail.com", 39));
		customers.add(new Customer(2L, "Jaan", "jaan@gmail.com", 49));
		customers.add(new Customer(3L, "Rein", "rein@gmail.com", 59));
		customers.add(new Customer(4L, "Peeter", "peeter@gmail.com", 29));
		customers.add(new Customer(5L, "Jack", "jack@gmail.com", 23));
		customers.add(new Customer(6L, "Veiko", "veiko@gmail.com", 49));
		customers.add(new Customer(7L, "Uuno", "uuno@gmail.com", 22));
		customers.add(new Customer(8L, "John", "john@gmail.com", 43));
		customers.add(new Customer(9L, "Maikel", "maikel@gmail.com", 19));
		customers.add(new Customer(10L, "Teet", "teet@gmail.com", 43));
	}

	public List<Customer> getAllCustomers(){
		return customers;
	}

	public Customer getCustomer(Long id){
		return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}
}
