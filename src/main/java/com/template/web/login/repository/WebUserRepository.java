package com.template.web.login.repository;

import com.template.web.login.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findById(String id);
}
