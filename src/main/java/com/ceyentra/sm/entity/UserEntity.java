package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user")
public class UserEntity {

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

    @Column(name = "nic")
    String nic;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "home_address")
    String homeAddress;

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

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    @Enumerated(value = EnumType.STRING)
    UserStatus status;

    public UserEntity(String name, String email, String password, UserRole userRole, UserStatus status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nic='" + nic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", userRole=" + userRole +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", status=" + status +
                '}';
    }
}
