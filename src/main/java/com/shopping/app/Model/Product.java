package com.shopping.app.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productname")
    private String name;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "availableQuantity")
    private String availableQuantity;

    @Column(name = "price")
    private String price;

}
