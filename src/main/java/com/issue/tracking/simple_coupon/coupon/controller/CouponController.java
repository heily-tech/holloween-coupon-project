package com.issue.tracking.simple_coupon.coupon.controller;

import com.issue.tracking.simple_coupon.coupon.entity.Coupon;
import com.issue.tracking.simple_coupon.coupon.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/generate")
    public String generateCoupon(Model model) {
        Coupon coupon = couponService.generateCoupon();
        model.addAttribute("couponCode", coupon.getCouponCode());
        return "index";
    }

    // 쿠폰 발급 개수 확인하기 기능 추가
}