package com.example.movie_ticket.controller;

import com.example.movie_ticket.dto.PasswordResetDto;
import com.example.movie_ticket.model.Account;
import com.example.movie_ticket.model.PasswordResetToken;
import com.example.movie_ticket.repository.IPasswordResetTokenRepository;
import com.example.movie_ticket.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/reset-password")
public class PasswordResetController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IPasswordResetTokenRepository tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @ModelAttribute("passwordResetForm")
    public PasswordResetDto passwordReset() {
        return new PasswordResetDto();
    }

    @GetMapping
    public String displayResetPasswordPage(@RequestParam(required = false) String token,
                                           Model model) {

        PasswordResetToken resetToken = tokenRepository.findByToken(token);
        if (resetToken == null) {
            model.addAttribute("error", "Không thể tìm thấy mã thông báo đặt lại mật khẩu.");
        } else if (resetToken.isExpired()) {
            model.addAttribute("error", "Mã thông báo đã hết hạn, vui lòng yêu cầu đặt lại mật khẩu mới.");
        } else {
            model.addAttribute("token", resetToken.getToken());
        }

        return "reset-password";
    }

    @PostMapping
    @Transactional
    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Valid PasswordResetDto form,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".passwordResetForm", result);
            redirectAttributes.addFlashAttribute("passwordResetForm", form);
            return "redirect:/reset-password?token=" + form.getToken();
        }

        PasswordResetToken token = tokenRepository.findByToken(form.getToken());
        Account user = token.getAccount();
        String updatedPassword = passwordEncoder.encode(form.getPassword());
        accountService.updatePassword(updatedPassword, user.getId());
        tokenRepository.delete(token);
        redirectAttributes.addFlashAttribute("message", "Đặt lại mật khẩu thành công");
        return "redirect:/login?resetSuccess";
    }
}
