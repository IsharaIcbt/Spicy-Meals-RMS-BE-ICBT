/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 4:56 PM
 */
package com.ceyentra.sm.constant;

import com.ceyentra.sm.dto.SampleRequestDTO;
import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.web.request.SampleRequestRequestDTO;
import com.ceyentra.sm.dto.web.response.SampleRequestResponseDTO;
import com.ceyentra.sm.dto.web.response.SampleRequestResponseUserDTO;
import com.ceyentra.sm.dto.web.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
public class FunctionalConstant {

    public static final Function<SampleRequestDTO, SampleRequestResponseDTO> SAMPLE_REQUEST_DTO_TO_SAMPLE_REQUEST_RESPONSE_DTO = (sampleRequestDTO) -> {
        log.info("Start function SAMPLE_REQUEST_DTO_TO_SAMPLE_REQUEST_RESPONSE_DTO @Param sampleRequestDTO : {}", sampleRequestDTO);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //get manager
            UserDTO manager = sampleRequestDTO.getManager();
            SampleRequestResponseUserDTO managerResponse = SampleRequestResponseUserDTO.builder()
                    .id(manager == null ? null : manager.getId())
                    .operationalStatus(sampleRequestDTO.getManagerOperationalStatus().name())
                    .email(manager == null ? null : manager.getEmail())
                    .name(manager == null ? null : manager.getName())
                    .comment(sampleRequestDTO.getManagerComment())
                    .reviewedDate(sampleRequestDTO.getManagerReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getManagerReviewedDate()))
                    .build();

            //get sample request employee
            UserDTO sreEmployee = sampleRequestDTO.getSampleRoomEmployee();
            SampleRequestResponseUserDTO sreResponse = SampleRequestResponseUserDTO.builder()
                    .id(sreEmployee == null ? null : sreEmployee.getId())
                    .operationalStatus(sampleRequestDTO.getSampleRoomEmployeeOperationalStatus().name())
                    .email(sreEmployee == null ? null : sreEmployee.getEmail())
                    .name(sreEmployee == null ? null : sreEmployee.getName())
                    .comment(sampleRequestDTO.getSampleRoomEmployeeComment())
                    .reviewedDate(sampleRequestDTO.getSampleRoomEmployeeReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getSampleRoomEmployeeReviewedDate()))
                    .build();

            return SampleRequestResponseDTO.builder()
                    .id(sampleRequestDTO.getId())
                    .buyerId(sampleRequestDTO.getBuyer().getId())
                    .buyerName(sampleRequestDTO.getBuyer().getName())
                    .lotNumber(sampleRequestDTO.getLotNumber())
                    .saleNumber(sampleRequestDTO.getSaleNumber())
                    .buyerComment(sampleRequestDTO.getBuyerComment())
                    .requestedDate(dateFormat.format(sampleRequestDTO.getRequestedDate()))
                    .status(sampleRequestDTO.getStatus())
                    .manager(managerResponse)
                    .sampleRoomEmployee(sreResponse)
                    .build();

        } catch (Exception e) {
            log.error("function SAMPLE_REQUEST_DTO_TO_SAMPLE_REQUEST_RESPONSE_DTO : {}", e.getMessage(), e);
            throw e;
        }
    };
    public static final Function<List<SampleRequestDTO>, List<SampleRequestResponseDTO>> SAMPLE_REQUEST_DTO_LIST_TO_SAMPLE_REQUEST_RESPONSE_DTO_LIST = (sampleRequestDTOList) -> {
        log.info("Start function SAMPLE_REQUEST_DTO_LIST_TO_SAMPLE_REQUEST_RESPONSE_DTO_LIST @Param sampleRequestDTO");
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return sampleRequestDTOList.stream()
                    .map(sampleRequestDTO -> {
                        //get manager
                        UserDTO manager = sampleRequestDTO.getManager();
                        SampleRequestResponseUserDTO managerResponse = SampleRequestResponseUserDTO.builder()
                                .id(manager == null ? null : manager.getId())
                                .operationalStatus(sampleRequestDTO.getManagerOperationalStatus().name())
                                .email(manager == null ? null : manager.getEmail())
                                .name(manager == null ? null : manager.getName())
                                .comment(sampleRequestDTO.getManagerComment())
                                .reviewedDate(sampleRequestDTO.getManagerReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getManagerReviewedDate()))
                                .build();

                        //get sample request employee
                        UserDTO sreEmployee = sampleRequestDTO.getSampleRoomEmployee();
                        SampleRequestResponseUserDTO sreResponse = SampleRequestResponseUserDTO.builder()
                                .id(sreEmployee == null ? null : sreEmployee.getId())
                                .operationalStatus(sampleRequestDTO.getSampleRoomEmployeeOperationalStatus().name())
                                .email(sreEmployee == null ? null : sreEmployee.getEmail())
                                .name(sreEmployee == null ? null : sreEmployee.getName())
                                .comment(sampleRequestDTO.getSampleRoomEmployeeComment())
                                .reviewedDate(sampleRequestDTO.getSampleRoomEmployeeReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getSampleRoomEmployeeReviewedDate()))
                                .build();

                        return SampleRequestResponseDTO.builder()
                                .id(sampleRequestDTO.getId())
                                .buyerId(sampleRequestDTO.getBuyer().getId())
                                .buyerName(sampleRequestDTO.getBuyer().getName())
                                .lotNumber(sampleRequestDTO.getLotNumber())
                                .saleNumber(sampleRequestDTO.getSaleNumber())
                                .buyerComment(sampleRequestDTO.getBuyerComment())
                                .requestedDate(dateFormat.format(sampleRequestDTO.getRequestedDate()))
                                .status(sampleRequestDTO.getStatus())
                                .manager(managerResponse)
                                .sampleRoomEmployee(sreResponse)
                                .build();
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("function SAMPLE_REQUEST_DTO_LIST_TO_SAMPLE_REQUEST_RESPONSE_DTO_LIST : {}", e.getMessage(), e);
            throw e;
        }
    };
    public static final Function<Page<SampleRequestDTO>, Page<SampleRequestResponseDTO>> SAMPLE_REQUEST_DTO_PAGE_TO_SAMPLE_REQUEST_RESPONSE_DTO_PAGE = (sampleRequestDTOList) -> {
        log.info("Start function SAMPLE_REQUEST_DTO_PAGE_TO_SAMPLE_REQUEST_RESPONSE_DTO_PAGE @Param sampleRequestDTOList");
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return sampleRequestDTOList.map(sampleRequestDTO -> {
                //get manager
                UserDTO manager = sampleRequestDTO.getManager();
                SampleRequestResponseUserDTO managerResponse = SampleRequestResponseUserDTO.builder()
                        .id(manager == null ? null : manager.getId())
                        .operationalStatus(sampleRequestDTO.getManagerOperationalStatus().name())
                        .email(manager == null ? null : manager.getEmail())
                        .name(manager == null ? null : manager.getName())
                        .comment(sampleRequestDTO.getManagerComment())
                        .reviewedDate(sampleRequestDTO.getManagerReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getManagerReviewedDate()))
                        .build();

                //get sample request employee
                UserDTO sreEmployee = sampleRequestDTO.getSampleRoomEmployee();
                SampleRequestResponseUserDTO sreResponse = SampleRequestResponseUserDTO.builder()
                        .id(sreEmployee == null ? null : sreEmployee.getId())
                        .operationalStatus(sampleRequestDTO.getSampleRoomEmployeeOperationalStatus().name())
                        .email(sreEmployee == null ? null : sreEmployee.getEmail())
                        .name(sreEmployee == null ? null : sreEmployee.getName())
                        .comment(sampleRequestDTO.getSampleRoomEmployeeComment())
                        .reviewedDate(sampleRequestDTO.getSampleRoomEmployeeReviewedDate() == null ? null : dateFormat.format(sampleRequestDTO.getSampleRoomEmployeeReviewedDate()))
                        .build();

                return SampleRequestResponseDTO.builder()
                        .id(sampleRequestDTO.getId())
                        .buyerId(sampleRequestDTO.getBuyer().getId())
                        .buyerName(sampleRequestDTO.getBuyer().getName())
                        .lotNumber(sampleRequestDTO.getLotNumber())
                        .saleNumber(sampleRequestDTO.getSaleNumber())
                        .buyerComment(sampleRequestDTO.getBuyerComment())
                        .requestedDate(dateFormat.format(sampleRequestDTO.getRequestedDate()))
                        .status(sampleRequestDTO.getStatus())
                        .manager(managerResponse)
                        .sampleRoomEmployee(sreResponse)
                        .build();
            });

        } catch (Exception e) {
            log.error("function SAMPLE_REQUEST_DTO_PAGE_TO_SAMPLE_REQUEST_RESPONSE_DTO_PAGE : {}", e.getMessage(), e);
            throw e;
        }
    };
    private static final ModelMapper modelMapper = new ModelMapper();
//    public static final Function<SampleRequestEntity, SampleRequestDTO> SAMPLE_REQUEST_ENTITY_TO_SAMPLE_REQUEST_DTO = (sampleRequestEntity) -> {
//        log.info("Start function SAMPLE_REQUEST_ENTITY_TO_SAMPLE_REQUEST_DTO @Param sampleRequestEntity : {}", sampleRequestEntity);
//        try {
//            //get buyer entity
//            UserEntity buyerEntity = sampleRequestEntity.getBuyer();
//            UserDTO buyerDTO = buyerEntity == null ? null : modelMapper.map(buyerEntity, UserDTO.class);
//
//            //get manager entity
//            UserEntity managerEntity = sampleRequestEntity.getManager();
//            UserDTO managerDTO = managerEntity == null ? null : modelMapper.map(managerEntity, UserDTO.class);
//
//            //get sample room employee entity
//            UserEntity sreEmployeeEntity = sampleRequestEntity.getSampleRoomEmployee();
//            UserDTO sreDTO = sreEmployeeEntity == null ? null : modelMapper.map(sreEmployeeEntity, UserDTO.class);
//
//            return SampleRequestDTO.builder()
//                    .id(sampleRequestEntity.getId())
//                    .lotNumber(sampleRequestEntity.getLotNumber())
//                    .saleNumber(sampleRequestEntity.getSaleNumber())
//                    .requestedDate(sampleRequestEntity.getRequestedDate())
//                    .managerReviewedDate(sampleRequestEntity.getManagerReviewedDate())
//                    .sampleRoomEmployeeReviewedDate(sampleRequestEntity.getSampleRoomEmployeeReviewedDate())
//                    .buyerComment(sampleRequestEntity.getBuyerComment())
//                    .managerComment(sampleRequestEntity.getManagerComment())
//                    .sampleRoomEmployeeComment(sampleRequestEntity.getSampleRoomEmployeeComment())
//                    .managerOperationalStatus(sampleRequestEntity.getManagerOperationalStatus())
//                    .sampleRoomEmployeeOperationalStatus(sampleRequestEntity.getSampleRoomEmployeeOperationalStatus())
//                    .status(sampleRequestEntity.getStatus())
//                    .buyer(buyerDTO)
//                    .manager(managerDTO)
//                    .sampleRoomEmployee(sreDTO)
//                    .build();
//
//
//        } catch (Exception e) {
//            log.error("function SAMPLE_REQUEST_ENTITY_TO_SAMPLE_REQUEST_DTO : {}", e.getMessage(), e);
//            throw e;
//        }
//    };
    public static final Function<SampleRequestRequestDTO, SampleRequestDTO> TO_SAMPLE_REQUEST_DTO_FUNCTION = (sampleRequestRequestDTO) -> {
        log.info("Start function TO_SAMPLE_REQUEST_DTO_FUNCTION @Param userDTO : {}", sampleRequestRequestDTO);
        try {
            return modelMapper.map(sampleRequestRequestDTO, SampleRequestDTO.class);
        } catch (Exception e) {
            log.error("function TO_SAMPLE_REQUEST_DTO_FUNCTION : {}", e.getMessage(), e);
            throw e;
        }
    };
    public static final Function<UserDTO, UserResponseDTO> USER_DTO_USER_RESPONSE_DTO_FUNCTION = (userDTO) -> {
        log.info("Start function USER_DTO_USER_RESPONSE_DTO_FUNCTION @Param userDTO : {}", userDTO);
        try {
            return modelMapper.map(userDTO, UserResponseDTO.class);
        } catch (Exception e) {
            log.error("function USER_DTO_USER_RESPONSE_DTO_FUNCTION : {}", e.getMessage(), e);
            throw e;
        }
    };
    public static final Function<List<UserDTO>, List<UserResponseDTO>> USER_DTO_LIST_USER_RESPONSE_DTO_LIST_FUNCTION = (userDTOList) -> {
        log.info("Start function USER_DTO_USER_RESPONSE_DTO_FUNCTION @Param userDTO : {}", userDTOList);
        try {
            return modelMapper.map(userDTOList,
                    new TypeToken<List<UserResponseDTO>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("function USER_DTO_USER_RESPONSE_DTO_FUNCTION : {}", e.getMessage(), e);
            throw e;
        }
    };

}
