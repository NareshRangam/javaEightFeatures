package com.ss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
