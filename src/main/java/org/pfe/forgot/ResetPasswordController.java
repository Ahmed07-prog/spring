package org.pfe.forgot;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.pfe.user.User;
import org.pfe.user.UserRepository;
import org.pfe.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ResetPasswordController {
    private final JavaMailSender mailSender;
     
    private final UserService userService;
    private final UserRepository userRepository;
    @Value("${spring.mail.username}")
    private String sender;

    @PostMapping("/forgot")
    public ResponseEntity<?> ResponseEntity(@RequestBody PasswordRecoveryRequest passwordRecoveryRequest) throws
            MailSendException {
                String email = passwordRecoveryRequest.getEmail();
                if(userRepository.existsByEmail(email)) {
                String token = String.valueOf(System.currentTimeMillis());
                userService.updateResetPasswordToken(token, email);
        try {
            sendEmail(email, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("SENT: Check Your mail!");
    }
    else return ResponseEntity.badRequest().body("There is no account with this email" + email);
    }

    public String sendEmail(String recipientEmail, String token) {
        if(userRepository.existsByEmail(recipientEmail)) {
            String subject = "Someone requested that the password be reset for the following account:";
            String content = "Votre Code de verificatiotn est :" + token ;
            try {
                // Creating a simple mail message
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(recipientEmail);
                mailMessage.setText(content);
                mailMessage.setSubject(subject);
                // Sending the mail
                mailSender.send(mailMessage);
            }
            // Catch block to handle the exceptions
            catch (MailAuthenticationException e) {
                return "Error while Sending Mail" + e;
            }
            return "Mail Sent Successfully...";
        }
        else return "Email Does Not exists";

    }

    @PostMapping("/reset")
    public ResponseEntity<?> ResponseEntity(@RequestBody ResetPasswordRequest request){
        String token = request.getToken();
        String password = request.getPassword();
        User user = userService.getByResetPasswordToken(token);
        if (user == null) {
            return ResponseEntity.badRequest().body("Error!");
        } else {
            userService.updatePassword(user, password);
        }
        return ResponseEntity.ok().body("Done!");
    }
}
