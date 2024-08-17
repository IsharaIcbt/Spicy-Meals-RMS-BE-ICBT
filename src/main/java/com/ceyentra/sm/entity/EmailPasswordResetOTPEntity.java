package com.ceyentra.sm.entity;

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
@Table(name = "email_password_reset_otp")
public class EmailPasswordResetOTPEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String otp;

    String email;

    @CreationTimestamp
    @Column(name = "created_date")
    Date createdDate;

    @Override
    public String toString() {
        return "EmailPasswordResetOTPEntity{" +
                "id=" + id +
                ", otp='" + otp + '\'' +
                ", email='" + email + '\'' +
                ", created_date=" + createdDate +
                '}';
    }
}
