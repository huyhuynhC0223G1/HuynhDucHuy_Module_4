package com.example.movie_ticket.service.impl;

import com.example.movie_ticket.model.Role;
import com.example.movie_ticket.repository.IRoleRepository;
import com.example.movie_ticket.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findRoleByName(String role) {
        return roleRepository.findRoleByName(role);
    }
}
