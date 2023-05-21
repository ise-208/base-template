package com.template.web.repository;

import com.template.web.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebUserMapperRepository {
//    public Collection<User> findAll();
    @Select("select * from users where id = #{id}")
    Account findById(String id);
//    public void create(User user);
//    public void saveUser(User user);
//    public List<User> findAllUsers();
}
