/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 4:56 PM
 */
package com.ceyentra.sm.constant;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.web.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Log4j2
public class FunctionalConstant {
    private static final ModelMapper modelMapper = new ModelMapper();
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
