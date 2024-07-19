/**
 * @author :  Dinuth Dheeraka
 * Created : 8/3/2023 4:43 PM
 */
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

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "user_role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    UserRole userRole;

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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                ", userRole=" + userRole +
                ", status=" + status +
                '}';
    }
}
