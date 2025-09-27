package com.example.jobapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jobapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE "
            + "LOWER(u.email) LIKE LOWER(CONCAT('%', :keywords, '%')) OR "
            + "LOWER(u.name) LIKE LOWER(CONCAT('%', :keywords, '%'))")
    List<User> searchByKeywords(@Param("keywords") String keywords);

}
