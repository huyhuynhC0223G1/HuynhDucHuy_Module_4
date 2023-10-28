package com.example.movie_ticket.service.impl;

import com.example.movie_ticket.model.User;
import com.example.movie_ticket.repository.IUserRepository;
import com.example.movie_ticket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
   @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
