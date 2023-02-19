package com.template.web.login;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public WebUser create(WebUser user, String password) {
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        return accountRepository.save(user);
    }
}
