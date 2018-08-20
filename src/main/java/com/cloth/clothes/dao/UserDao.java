package com.cloth.clothes.dao;

import com.cloth.clothes.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM user")
    List<User> selectUser();

    @Select("select * from user where name = #{userName}")
    User findUserByName(String userName);

    @Select("SELECT * FROM user WHERE id = #{uid}")
    User findUserById(String uid);
}
