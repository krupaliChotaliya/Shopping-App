package com.shopping.app.Repository;

import com.shopping.app.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    @Query(value = "SELECT * FROM coupon WHERE coupon_code = :couponCode", nativeQuery = true)
    Coupon findCouponByCouponCode(String couponCode);
}
