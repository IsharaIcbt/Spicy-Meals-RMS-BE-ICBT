package com.ceyentra.sm.entity;

import com.ceyentra.sm.enums.CommonFunctionalFrequency;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.FacilityType;
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
@Table(name = "facility")
public class FacilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String imgURL;

    @Column(length = 1000)
    String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "frequency", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'MONTHLY'")
    CommonFunctionalFrequency frequency;

    @Column(name = "reserved_date")
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    Date reservedDate;

    String start;

    String close;

    @Column(name = "week_days")
    String weekDays;

    @Column(name = "max_participant_count")
    Integer maxParticipantCount;

    Float price;

    Float discount;

    @Column(name = "facility_type")
    @Enumerated(value = EnumType.STRING)
    FacilityType facilityType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurant;

    @Column(name = "created_by")
    Long createdBy;

    @Column(name = "availability")
    @Enumerated(value = EnumType.STRING)
    CommonStatus availability;

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
        return "FacilityEntity{" +
                "name='" + name + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", description='" + description + '\'' +
                ", frequency=" + frequency +
                ", reservedDate=" + reservedDate +
                ", start='" + start + '\'' +
                ", close='" + close + '\'' +
                ", weekDays='" + weekDays + '\'' +
                ", maxParticipantCount=" + maxParticipantCount +
                ", price=" + price +
                ", discount=" + discount +
                ", facilityType=" + facilityType +
                ", restaurant=" + restaurant.id +
                ", createdBy=" + createdBy +
                ", availability=" + availability +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
