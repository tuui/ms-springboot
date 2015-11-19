package org.tuui;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<>();
	static {
		products.add(new Product(1L, "Knife", new BigDecimal(12), "Can cut"));
		products.add(new Product(2L, "Gun", new BigDecimal(122), "Can shoot"));
		products.add(new Product(2L, "Car", new BigDecimal(1200), "Can drive"));
	}

	public Product getProduct(Long id){
		return products.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}
}
