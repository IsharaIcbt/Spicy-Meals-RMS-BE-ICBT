/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 1:04 PM
 */
package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.CommonStatus;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String branchCode;
    private CommonStatus status;
    private Date createdDate;
    private Date updatedDate;

}
