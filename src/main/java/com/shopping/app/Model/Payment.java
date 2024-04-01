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
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "status")
    private String status;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private String description;
}
