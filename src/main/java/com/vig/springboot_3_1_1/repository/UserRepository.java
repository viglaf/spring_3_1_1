package com.vig.springboot_3_1_1.repository;

import com.vig.springboot_3_1_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
