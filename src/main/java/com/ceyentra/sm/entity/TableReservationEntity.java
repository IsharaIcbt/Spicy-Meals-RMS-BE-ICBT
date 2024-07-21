package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.TableReservationOperationalStatus;
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
@Table(name = "tables_reservation")
public class TableReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "reservation_code")
    String reservationCode;

    Integer max_count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    UserEntity customer;

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    @Column(name = "reserved_date")
    Date reservedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    CommonStatus status;

    @Column(name = "approved_by")
    Long approvedBy;

    @Column(name = "approved_note")
    String approvedNote;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "operational_status", columnDefinition = "VARCHAR(255) DEFAULT 'NEW'")
    TableReservationOperationalStatus operationalStatus;

    @Column(name = "created_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date createdDate;

    @Column(name = "updated_date")
    @CreationTimestamp
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date updatedDate;

    @Override
    public String toString() {
        return "TableReservationEntity{" +
                "reservationCode='" + reservationCode + '\'' +
                ", max_count=" + max_count +
                ", restaurant=" + restaurant.id +
                ", customer=" + customer.id +
                ", reservedDate=" + reservedDate +
                ", status=" + status +
                ", approvedBy=" + approvedBy +
                ", approvedNote='" + approvedNote + '\'' +
                ", operationalStatus=" + operationalStatus +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
