package com.example.movie_ticket.service;

import com.example.movie_ticket.model.Role;

public interface IRoleService {
    Role findRoleByName(String name);
}
