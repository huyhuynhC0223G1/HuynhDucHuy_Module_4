package com.example.movie_ticket.repository;

import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRoleRepository extends JpaRepository<AccountRole,Long> {
    List<AccountRole> findAccountRoleByAccountId(Long idAccount);
}
