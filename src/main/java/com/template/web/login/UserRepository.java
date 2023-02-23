package com.template.web.login;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<WebUser, Long> {
    WebUser findById(String id);

}
