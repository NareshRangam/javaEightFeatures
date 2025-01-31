package com.ss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.dto.Coupon;
import com.ss.entity.Product;
import com.ss.repo.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product)
	{
		Coupon coupon = restTemplate.getForObject("http://localhost:9001/coupon/coupons/"+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);
	}

}
