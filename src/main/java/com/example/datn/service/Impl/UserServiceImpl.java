package com.example.datn.service.Impl;

import com.example.datn.components.mail.Mail;
import com.example.datn.components.mail.MailService;
import com.example.datn.constant.Constants;
import com.example.datn.dto.CustomUserDetails;
import com.example.datn.dto.EmailOrUser;
import com.example.datn.dto.LoginDto;
import com.example.datn.dto.UserCreateDto;
import com.example.datn.dto.VerifyDto;
import com.example.datn.entity.User;
import com.example.datn.entity.VerifyAccount;
import com.example.datn.repository.UserRepository;
import com.example.datn.repository.VerifyAccountRepository;
import com.example.datn.service.UserService;
import com.example.datn.utils.RandomUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author vietnq
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Autowired
    private VerifyAccountRepository verifyAccountRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User register(UserCreateDto userCreateDto) throws Exception {
        String email = userCreateDto.getEmail();
        String username = userCreateDto.getUsername();
        String password = userCreateDto.getPassword();
        String firstName = userCreateDto.getFirstName();
        String lastName = userCreateDto.getLastName();

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(false);
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());

        sendEmail(user);
        return userRepository.save(user);
    }

    @Override
    public void verify(VerifyDto verifyDto) {
        try {
            String token = verifyDto.getToken();
            VerifyAccount verifyAccount = verifyAccountRepository.findByToken(token);
            User user = verifyAccount.getUser();
            user.setActive(true);
            userRepository.save(user);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public Map<String, String> login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            String role = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse(null);
            SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String token = Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .claim("role", role)
                    .signWith(SignatureAlgorithm.HS256, KEY).compact();
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("username", userDetails.getUsername());
            response.put("role", role);
            response.put("firstName", userDetails.getFirstName());
            response.put("lastName", userDetails.getLastName());

            return response;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public void forgotPassword(String usernameOrEmail) {
        try {
            User user = getEmailOrUser(usernameOrEmail);
            String password = generateRandomPassword();
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            VerifyAccount verifyAccount = new VerifyAccount();
            verifyAccount.setUser(user);
            verifyAccount.setCreatedDate(LocalDateTime.now());
            verifyAccount.setExpiredDataToken(5);
            verifyAccount.setToken(password);
            verifyAccountRepository.save(verifyAccount);

            Map<String, Object> maps = new HashMap<>();
            maps.put("user", user);
            maps.put("token", password);

            Mail mail = new Mail();
            mail.setFrom("postmaster@mg.iteacode.com");
            mail.setSubject("Mail xác nhận đăng ký.");
            mail.setTo(user.getEmail());
            mail.setModel(maps);
            mailService.sendEmail(mail);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private void sendEmail(User user) {
        try {
            String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();

            VerifyAccount verifyAccount = new VerifyAccount();
            verifyAccount.setUser(user);
            verifyAccount.setCreatedDate(LocalDateTime.now());
            verifyAccount.setExpiredDataToken(5);
            verifyAccount.setToken(token);
            verifyAccountRepository.save(verifyAccount);

            Map<String, Object> maps = new HashMap<>();
            maps.put("user", user);
            maps.put("token", token);

            Mail mail = new Mail();
            mail.setFrom("postmaster@mg.iteacode.com");
            mail.setSubject("Mail xác nhận đăng ký.");
            mail.setTo(user.getEmail());
            mail.setModel(maps);
            mailService.sendEmail(mail);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private User getEmailOrUser(String usernameOrEmail) {
        try {
            EmailOrUser emailOrUser = new EmailOrUser();
            if (usernameOrEmail.contains("@")) {
                if (!isValidEmail(usernameOrEmail)) {
                    throw new RuntimeException(Constants.EMAIL_INVALID);
                }
                emailOrUser.setEmail(usernameOrEmail);
            } else {
                emailOrUser.setUsername(usernameOrEmail);
            }
            User user = userRepository.findByUsernameOrEmail(emailOrUser.getUsername(), emailOrUser.getEmail());
            return user;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private String generateRandomPassword() {
        int length = 12;
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        String allChars = upperCaseChars + lowerCaseChars + digits + specialChars;
        Random random = new Random();

        StringBuilder password = new StringBuilder();

        password.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length())));
        password.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        for (int i = password.length(); i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        Collections.shuffle(Arrays.asList(password.toString().split("")));

        return password.toString();
    }
}
