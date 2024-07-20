package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "meal_order")
public class MealOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "order_code", unique = true)
    String orderId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "operational_status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'NEW'")
    MealOperationalStatus operationalStatus;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    CommonStatus status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "meal_order_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ONLINE'")
    MealOrderType mealOrderType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    UserEntity userEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurant;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date updatedDate;

}
