package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.StaffEntity;
import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findUserEntityByStatus(UserStatus status);

    Optional<UserEntity> findUserEntityByIdAndStatus(Long id, UserStatus status);

    @Modifying
    @Query(value = "UPDATE user u SET u.status=:status WHERE u.id=:id", nativeQuery = true)
    void updateUserStatus(@Param("id") Long id, @Param("status") String status);

    @Modifying
    @Query(value = "UPDATE user u SET u.password=?2 WHERE u.id=?1", nativeQuery = true)
    void updateUserPassword(Long id, String password);

    @Query(value = "SELECT u.email FROM user u WHERE u.user_role=?1 AND status='ACTIVE'", nativeQuery = true)
    List<String> findUserEmailsByUserRole(String role);

    @Modifying
    @Query(value = "UPDATE user u SET u.email =?2 WHERE u.id=?1", nativeQuery = true)
    void updateUserEmail(@Param("id") Long id, @Param("email") String email);
}
