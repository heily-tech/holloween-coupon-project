package com.issue.tracking.simple_coupon.coupon.repository;

import com.issue.tracking.simple_coupon.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}