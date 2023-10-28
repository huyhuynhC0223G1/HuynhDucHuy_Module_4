package com.example.spring_security.repository;

import com.example.spring_security.entity.AppUser;
import com.example.spring_security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
