package com.shopping.app.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="coupon")
public class Coupon {

    @Id
    @Column(nullable = false,unique = true)
    private String couponCode;
    @Column(nullable = false)
    private int discountPercentage;
}


