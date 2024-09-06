package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.UserRole;
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
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "temp_password", nullable = false)
    String tempPassword;

    @Column(name = "nic")
    String nic;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "home_address")
    String homeAddress;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    CommonStatus status;

    @Column(name = "user_role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    UserRole userRole;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date updatedDate;

    public AdminEntity(String name, String email, String password, String nic, String phoneNumber,
                       String homeAddress, CommonStatus status, UserRole userRole, Date createdDate,
                       Date updatedDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.status = status;
        this.userRole = userRole;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
