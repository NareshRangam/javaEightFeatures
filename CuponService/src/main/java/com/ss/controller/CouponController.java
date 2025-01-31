package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.entity.Coupon;
import com.ss.repo.CouponRepository;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponRepository couponRepository;
	
	@Value("${url}")
	private String name;
	
	
	
	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon)
	{
		return couponRepository.save(coupon);
		
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code)
	{
		System.out.println("name::"+name);
		return couponRepository.findByCode(code);
	}
}
