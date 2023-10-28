package com.example.movie_ticket.controller;

import com.example.movie_ticket.dto.UserRegistrationDto;
import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.model.AccountRole;
import com.example.movie_ticket.model.Role;
import com.example.movie_ticket.model.User;
import com.example.movie_ticket.service.IAccountRoleService;
import com.example.movie_ticket.service.IAccountService;
import com.example.movie_ticket.service.IRoleService;
import com.example.movie_ticket.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IAccountRoleService accountRoleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private static final String ROLE_DEFAULT = "ROLE_USER";

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result, Model model) {

        Account existing = accountService.findByEmail(userDto.getEmail());
        Account username = accountService.findByUser(userDto.getUsername());
        if (existing != null) {
            result.rejectValue("email", null, "Đã có một tài khoản được đăng ký với email đó");
        }
        if (username != null) {
            result.rejectValue("username", null, "Tên đăng nhập đã tồn tại");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        Account account = new Account();
        User user = new User();
        Role role = roleService.findRoleByName(ROLE_DEFAULT);
        BeanUtils.copyProperties(userDto, account);
        BeanUtils.copyProperties(userDto, user);
        account.setPassword(passwordEncoder.encode(userDto.getPassword()));
        account.setFlagDelete(false);
        account.setEmail(userDto.getEmail());
        account.setUsername(userDto.getUsername());
        accountService.save(account);
        user.setAccount(account);
        user.setName(userDto.getFullName());
        user.setBirthday(userDto.getBirthday());
        user.setPhone(userDto.getPhone());
        userService.save(user);
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        accountRole.setRole(role);
        accountRoleService.save(accountRole);
        model.addAttribute("message", "Đăng Kí Thành Công");
        return "login";
    }

}
