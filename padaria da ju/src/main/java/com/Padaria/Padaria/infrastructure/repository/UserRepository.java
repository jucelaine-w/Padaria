package com.Padaria.Padaria.infrastructure.repository;

import com.Padaria.Padaria.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
        User findByUsername(String username);
        }

