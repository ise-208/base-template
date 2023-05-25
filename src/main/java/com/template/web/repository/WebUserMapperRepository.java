package com.template.web.repository;

import com.template.web.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Mapper
public interface WebUserMapperRepository {
    //    public Collection<User> findAll();
    @Select("select * from users where id = #{id}")
    public Account findById(String id);

}
