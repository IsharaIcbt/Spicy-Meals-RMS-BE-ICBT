package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.enums.UserRole;
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
@Table(name = "query_entity")
public class QueryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "meal_order_id")
    MealOrderEntity mealOrder;

    @ManyToOne
    @JoinColumn(name = "table_reservation_id")
    TableReservationEntity tableReservation;

    @Column(name = "query_type")
    @Enumerated(value = EnumType.STRING)
    QueryType queryType;

    String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    AdminEntity admin;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    StaffEntity staff;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    UserRole userRole;

    @Column(name = "created_date")
    @CreationTimestamp
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    Date updatedDate;

    @Enumerated(value = EnumType.STRING)
    CommonStatus status;
}
