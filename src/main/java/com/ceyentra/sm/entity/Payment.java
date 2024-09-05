package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.PaymentStatus;
import com.ceyentra.sm.enums.QueryType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Float price;

    @Enumerated(EnumType.STRING)
    @Column(name = "query_type")
    QueryType queryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "meal_order_id")
    MealOrderEntity mealOrder;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    TableReservationEntity tableReservation;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date updatedDate;
}
