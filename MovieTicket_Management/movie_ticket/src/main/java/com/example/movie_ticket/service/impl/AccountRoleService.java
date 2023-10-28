package com.example.movie_ticket.service.impl;

import com.example.movie_ticket.model.AccountRole;
import com.example.movie_ticket.repository.IAccountRepository;
import com.example.movie_ticket.repository.IAccountRoleRepository;
import com.example.movie_ticket.service.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleService implements IAccountRoleService {
    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Override
    public void save(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }
}
