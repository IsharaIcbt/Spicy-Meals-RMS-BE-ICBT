package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveRestaurantRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String branchCode;
    private CommonStatus status;
}
