package com.example.jobapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jobapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPhoneAndEmail(String phone, String email);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE "
            + "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keywords, '%')) OR "
            + "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keywords, '%')) OR "
            + "LOWER(u.email) LIKE LOWER(CONCAT('%', :keywords, '%')) OR "
            + "LOWER(u.phone) LIKE LOWER(CONCAT('%', :keywords, '%'))")
    List<User> searchByKeywords(@Param("keywords") String keywords);

}
