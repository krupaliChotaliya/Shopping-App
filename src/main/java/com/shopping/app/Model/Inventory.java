package com.shopping.app.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productName")
    private String name;

    @Column(name = "totalQuantity")
    private String totalQuantity;

    @Column(name = "availableQuantity")
    private String availableQuantity;

    @Column(name = "price")
    private String price;

}
