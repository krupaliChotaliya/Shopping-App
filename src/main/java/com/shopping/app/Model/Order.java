package com.shopping.app.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private String amount;

    @ManyToOne
    private User user;

    @Column(name = "productId")
    private int productId;

    @Column(name = "date")
    private LocalDate date;
}
