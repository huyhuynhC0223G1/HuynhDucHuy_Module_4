package com.example.movie_ticket.controller;

import com.example.movie_ticket.dto.PasswordForgotDto;
import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.model.Mail;
import com.example.movie_ticket.model.PasswordResetToken;
import com.example.movie_ticket.repository.IPasswordResetTokenRepository;
import com.example.movie_ticket.service.IAccountService;
import com.example.movie_ticket.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/forgot-password")
public class PasswordForgotController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IPasswordResetTokenRepository tokenRepository;
    @Autowired
    private EmailService emailService;

    @ModelAttribute("forgotPasswordForm")
    public PasswordForgotDto forgotPasswordDto() {
        return new PasswordForgotDto();
    }

    @GetMapping
    public String displayForgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping
    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Valid PasswordForgotDto form,
                                            BindingResult result,
                                            HttpServletRequest request) {

        if (result.hasErrors()) {
            return "forgot-password";
        }

        Account account = accountService.findByEmail(form.getEmail());
        if (account == null) {
            result.rejectValue("email", null, "Chúng tôi không thể tìm thấy tài khoản cho địa chỉ email đó.");
            return "forgot-password";
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setAccount(account);
        token.setExpiryDate(1);
        tokenRepository.save(token);

        Mail mail = new Mail();
        mail.setFrom("namhung024@gmail.com");
        mail.setTo(account.getEmail());
        mail.setSubject("Yêu cầu lấy lại mật khẩu?");

        HashMap<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("account", account);
        model.put("signature", "Mr.CongNamPham");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        model.put("resetUrl", url + "/reset-password?token=" + token.getToken());
        mail.setModel(model);
        emailService.sendEmail(mail);

        return "redirect:/forgot-password?success";
    }
}
