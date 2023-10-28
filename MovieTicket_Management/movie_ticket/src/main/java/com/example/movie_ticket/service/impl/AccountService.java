package com.example.movie_ticket.service.impl;

import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.model.AccountRole;

import com.example.movie_ticket.repository.IAccountRepository;
import com.example.movie_ticket.repository.IAccountRoleRepository;
import com.example.movie_ticket.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountRoleRepository accountRoleRepository;


    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account findByUser(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updatePassword(String password, Long accountId) {
        accountRepository.updatePassword(password, accountId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("email hoặc mật khẩu không đúng");
        }
        List<AccountRole> accountRoles = this.accountRoleRepository.findAccountRoleByAccountId(account.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (accountRoles != null) {
            for (AccountRole accountRole : accountRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(accountRole.getRole().getName());
                grantedAuthorities.add(authority);
            }
        }
        UserDetails userDetails = new User(account.getEmail(), account.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
