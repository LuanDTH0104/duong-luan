package com.org.clockshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "address_his_id")
    private Integer addressHisId;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_method")
    private String paymentMethod;

    public Order(Integer userId, Integer addressHisId, String createDate, String description, String paymentMethod) {
        this.userId = userId;
        this.addressHisId = addressHisId;
        this.createDate = createDate;
        this.description = description;
        this.paymentMethod = paymentMethod;
    }
}
