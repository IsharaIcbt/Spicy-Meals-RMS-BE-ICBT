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
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "branch_code")
    String branchCode;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    Set<StaffEntity> staffEntities;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    List<FacilityEntity> facilityEntities;

    @Enumerated(value = EnumType.STRING)
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

    public RestaurantEntity(String name, String email, String phone, String address, String branchCode, Set<StaffEntity> staffEntities, CommonStatus status, Date createdDate, Date updatedDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.branchCode = branchCode;
        this.staffEntities = staffEntities;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
