package com.issue.tracking.simple_coupon.coupon.service;

import com.issue.tracking.simple_coupon.coupon.entity.Coupon;
import com.issue.tracking.simple_coupon.coupon.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon generateCoupon() {

        long count = couponRepository.count() + 1;

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String number = String.format("%03d", count);
        String code = today + "-" + number;

        Coupon coupon = new Coupon();
        coupon.setCouponCode(code);

        return couponRepository.save(coupon);
    }

    // 쿠폰 발급 개수 확인하기 기능 추가
    public long getCouponCount() {
        return couponRepository.count();
    }
}