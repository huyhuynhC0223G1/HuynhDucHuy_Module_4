package com.example.movie_ticket.model;


import javax.persistence.*;

@Entity
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public AccountRole() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public AccountRole(Long id, Account account, Role role) {
        this.id = id;
        this.account = account;
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountId) {
        this.account = accountId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
