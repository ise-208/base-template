package com.template.web.login.repository;

import com.template.web.login.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
//@Component
public interface WebUserMapper {
//    public Collection<User> findAll();
    @Select("select * from users where id = #{id}")
    public Account findById(String id);
//    public void create(User user);
//    public void saveUser(User user);
//    public List<User> findAllUsers();
}
