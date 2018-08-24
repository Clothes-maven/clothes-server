package com.cloth.clothes.dao;

import com.cloth.clothes.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM user")
    List<User> selectUser();

    @Select("select * from user where name = #{userName}")
    @Results({
            @Result(property = "address", column = "address",
                    one = @One(select = "com.cloth.clothes.dao.StoreDao.findStoreById", fetchType = FetchType.EAGER))
    })
    User findUserByName(String userName);

    @Select("SELECT * FROM user WHERE id = #{uid}")
    User findUserById(String uid);
}
