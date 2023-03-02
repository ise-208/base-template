package com.template.web.login;

import org.springframework.data.jpa.repository.JpaRepository;
import com.template.web.login.WebUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<WebUser, Long> {
    WebUser findById(String id);


}
