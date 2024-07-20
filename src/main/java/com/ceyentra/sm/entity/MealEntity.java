package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.MealCategory;
import com.ceyentra.sm.enums.MealTypes;
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
@Table(name = "meal")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String imgURL;

    @Column(length = 1000)
    String description;

    Float price;

    Float discount;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'DRINK'")
    MealTypes subCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'LUNCH'")
    MealTypes mainCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'SRI_LANKAN'")
    MealCategory mealType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    CommonStatus status;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date updatedDate;
}
