/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 10:49 AM
 */
package com.ceyentra.sm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_otp")
public class UserOTPEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @Column(name = "otp")
    Integer otp;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    public UserOTPEntity(UserEntity userEntity, Integer otp) {
        this.userEntity = userEntity;
        this.otp = otp;
    }
}
