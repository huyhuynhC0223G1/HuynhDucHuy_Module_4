package com.example.movie_ticket.service;

import com.example.movie_ticket.dto.UserRegistrationDto;
import com.example.movie_ticket.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService extends UserDetailsService {
    Account findByEmail(String email);
    Account findByUser(String username);

    void save(Account account);

    void updatePassword(String password, Long userId);
}
