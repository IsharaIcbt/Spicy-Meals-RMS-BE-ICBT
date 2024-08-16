/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 8:21 PM
 */
package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.UserOTPDTO;
import com.ceyentra.sm.dto.web.request.UserSaveReqDTO;
import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.exception.UserException;
import com.ceyentra.sm.repository.AdminRepo;
import com.ceyentra.sm.repository.StaffRepo;
import com.ceyentra.sm.repository.UserRepo;
import com.ceyentra.sm.service.EmailService;
import com.ceyentra.sm.service.UserOTPService;
import com.ceyentra.sm.service.UserService;
import com.ceyentra.sm.util.EmailValidator;
import com.ceyentra.sm.util.OTPGenerator;
import com.ceyentra.sm.util.PasswordGenerator;
import com.ceyentra.sm.util.S3BucketUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.ceyentra.sm.constant.ApplicationConstant.*;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final UserOTPService userOTPService;
    private final ModelMapper modelMapper;
    private final EmailValidator emailValidator;
    private final PasswordGenerator passwordGenerator;
    private final OTPGenerator OTPGenerator;
    private final EmailService emailService;
    private final AdminRepo adminRepo;
    private final StaffRepo staffRepo;
    private final UserRepo userRepo;
    private final S3BucketUtil s3BucketUtil;

    @Override
    public void saveUser(UserSaveReqDTO userDTO) {
        log.info("Start function saveUser @Param userDTO : {}", userDTO);
        try {
            //validate email
            if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty() || !emailValidator.isValidEmail(userDTO.getEmail()))
                throw new UserException(INVALID_EMAIL, false, "Please enter a valid email address.");

            validateUniqueEmail(userDTO.getEmail());

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

            // Initialize fileURL variable
            String fileURL = null;
            MultipartFile file = userDTO.getImgFile();

            // Only attempt to upload the file if it is not null
            if (file != null && !file.isEmpty()) {
                fileURL = s3BucketUtil.uploadMultipartToS3bucket(MEALS_S3_BUCKET_FOLDER + s3BucketUtil.generateFileName(file), file);
            }

            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            userEntity.setId(0L);
            userEntity.setImg(fileURL);
            userEntity.setUserRole(UserRole.CUSTOMER);
            userEntity.setStatus(UserStatus.ACTIVE);
            userRepository.save(userEntity);

        } catch (Exception e) {
            log.error("function saveUser : {}", e.getMessage(), e);
            throw e;
        }
    }

    private void validateUniqueEmail(String email) {
        if (adminRepo.findByEmail(email).isPresent() || staffRepo.findByEmail(email).isPresent() || userRepo.findByEmail(email).isPresent()) {
            throw new ApplicationServiceException(200, false, "Email is already in use");
        }
    }

    @Override
    public List<UserDTO> getAllUsersByStatus(UserStatus userStatus) {
        log.info("Start function getAllUsersByStatus");
        try {

            return modelMapper.map(userRepository.findUserEntityByStatus(userStatus),
                    new TypeToken<List<UserDTO>>() {
                    }.getType());

        } catch (Exception e) {
            log.error("function getAllUsersByStatus : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserDTO getUserByUserId(Long id) {
        log.info("Start function getUserByUserId @Param : {}", id);
        try {

            Optional<UserEntity> byId = userRepository.findById(id);
            if (byId.isPresent() && byId.get().getStatus() == UserStatus.ACTIVE)
                return modelMapper.map(byId.get(), UserDTO.class);

            throw new UserException(USER_NOT_FOUND, false, "Sorry, the user with the provided ID was not found in our records. Please check the ID and try again.");

        } catch (Exception e) {
            log.error("function getUserByUserId : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void updateUserStatus(Long id, UserStatus status) {
        log.info("Start function UpdateUserStatus @Param : {}", status.name());
        try {
            //check user if exists
            Optional<UserEntity> byId = userRepository.findById(id);
            if (!byId.isPresent() || byId.get().getStatus() == UserStatus.DELETED)
                throw new UserException(USER_NOT_FOUND, false, "Sorry, the user with the provided ID was not found in our records. Please check the ID and try again.");

            //then update
            userRepository.updateUserStatus(id, status.name());
            userRepository.updateUserEmail(id, byId.get().getEmail() + "_DELETED_" + passwordGenerator.generatePassword(15));
        } catch (Exception e) {
            log.error("function UpdateUserStatus : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void resetUserPassword(String email) {
        //this methode will automatically generate a password for user and send the password to user via email.
        log.info("Start function resetUserPassword @Param email : {}", email);
        try {
            //check user if exists
            Optional<UserEntity> byEmail = userRepository.findUserEntityByEmail(email);
            if (!byEmail.isPresent() || byEmail.get().getStatus() == UserStatus.DELETED)
                throw new UserException(USER_NOT_FOUND, false, "Sorry, the user with the provided email was not found in our records. Please check the email and try again.");

            //encode password
            String newPassword = passwordGenerator.generatePassword(8);

            //update user password
            resetUserPassword(byEmail.get().getId(), newPassword, true);

        } catch (Exception e) {
            log.error("function resetUserPassword : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void resetUserPassword(Long id, String password, boolean isSendEmail) {
        log.info("Start function resetUserPassword @Param id : {} @Param password : {}", id, password);
        try {
            //check user if exists
            Optional<UserEntity> byId = userRepository.findById(id);
            if (!byId.isPresent() || byId.get().getStatus() == UserStatus.DELETED)
                throw new UserException(USER_NOT_FOUND, false, "Sorry, the user with the provided ID was not found in our records. Please check the ID and try again.");

            //encode password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);

            //update user password
            userRepository.updateUserPassword(id, encodedPassword);

            if (isSendEmail) {

                //begin email sending..

                //creating new userDTO containing user email and password
                UserDTO userDTO = UserDTO.builder()
                        .email(byId.get().getEmail())
                        .password(password)
                        .build();

                //send user email
                try {
                    emailService.sendUserNewPasswordEmail(userDTO);
                } catch (Exception e) {
                    throw new ApplicationServiceException(COMMON_ERROR_CODE, false, "Unable to send user new password.");
                }

            }

        } catch (Exception e) {
            log.error("function resetUserPassword : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void resetUserPassword(String email, int OTP, String password) {
        log.info("starting resetUserPassword @Param email : {} OTP : {} password : {}", email, OTP, password);
        try {

            //validate email and OTP
            userOTPService.validateUserOTP(email, OTP);

            //check user is exists with given email(directly call to the service method)
            UserDTO userByEmail = findUserByEmail(email);

            resetUserPassword(userByEmail.getId(), password, false);

        } catch (Exception e) {
            log.error("function resetUserPassword(email,OTP,password) : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        log.info("start function findUserByEmail @Param email : {}", email);
        try {
            Optional<UserEntity> userEntityByEmail = userRepository.findUserEntityByEmail(email);
            if (userEntityByEmail.isPresent())
                return modelMapper.map(userEntityByEmail.get(), UserDTO.class);

            throw new UserException(USER_NOT_FOUND, false,
                    "Sorry, the user with the provided email was not found in our records. Please check the email and try again.");
        } catch (Exception e) {
            log.error("function findUserByEmail {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendUserOTP(String email) {
        log.info("class : {} function sendUserOTP @Param email :  {}", getClass().getName(), email);
        try {

            //check user if exists with provided email(call to the service method)
            UserDTO userByEmail = findUserByEmail(email);

            //generate OTP
            int OTP = OTPGenerator.generateOTP();

            //save user with OTP
            userOTPService.addUserOTP(UserOTPDTO.builder()
                    .userDTO(userByEmail)
                    .OTP(OTP)
                    .build()
            );

            //send email to the user that contains OTP
            try {
                emailService.sendUserOTPEmail(userByEmail, OTP);
            } catch (Exception e) {
                throw new ApplicationServiceException(COMMON_ERROR_CODE, false, "Unable to the send OTP");
            }

        } catch (Exception e) {
            log.error("function sendUserOTP {}", e.getMessage(), e);
            throw e;
        }
    }
}
