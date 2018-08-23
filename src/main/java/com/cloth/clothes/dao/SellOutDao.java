package com.cloth.clothes.dao;

import com.cloth.clothes.bean.Clothes;
import com.cloth.clothes.bean.SellOut;
import com.cloth.clothes.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface SellOutDao {
    @Select("select * from clothes where id = #{id}")
    Clothes findClothesById(String id);

    @Select("select * from user where id = #{id}")
    User findUserById(String id);

    @Select("SELECT * FROM sellout WHERE createDate >= #{startTime} AND createDate <= #{endTime} AND number > 0")
    @Results({
            @Result(property = "subId", column = "subid"),
            @Result(property = "sell", column = "sell"),
            @Result(property = "createData", column = "createData"),
            @Result(property = "clothes", column = "clothesId",
                    one = @One(select = "com.cloth.clothes.dao.SellOutDao.findClothesById", fetchType = FetchType.EAGER)),
            @Result(property = "user", column = "userId",
                    one = @One(select = "com.cloth.clothes.dao.SellOutDao.findUserById", fetchType = FetchType.EAGER))
    })
    List<SellOut> findSellOutByData(@Param("startTime") String startTime, @Param("endTime") String endTime);

    @Insert("INSERT INTO sellout(clothesId,sell,userId,createDate) values(#{clothesId},#{sell},#{userId},#{createDate})")
    void insterSellOut(@Param("clothesId") String clothesId, @Param("sell") double sell,
                       @Param("userId") String userId, @Param("createDate") String createDate);
}
