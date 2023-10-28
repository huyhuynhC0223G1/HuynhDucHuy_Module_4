package com.example.movie_ticket.repository;

import com.example.movie_ticket.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
    Account findByUsername(String username);

    @Modifying
    @Query("update Account account set account.password = :password where account.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
