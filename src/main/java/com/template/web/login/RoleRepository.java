package com.template.web.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<WebRole, Long> {
    WebRole findByName(String name);
}
