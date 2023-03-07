package com.template.web.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findById(String id);
}
