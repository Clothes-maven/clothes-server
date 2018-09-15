package com.cloth.clothes.dao;

import com.cloth.clothes.bean.Clothdetail;
import com.cloth.clothes.bean.Clothes;
import com.cloth.clothes.bean.SellOut;
import com.cloth.clothes.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface SellOutDao {
    @Select("select * from clothdetail where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "size", column = "size"),
            @Result(property = "color", column = "color"),
            @Result(property = "number", column = "number"),
            @Result(property = "store", column = "store",
                    one = @One(select = "com.cloth.clothes.dao.StoreDao.findStoreById", fetchType = FetchType.EAGER)),
            @Result(property = "clothe", column = "clothe",
                    one = @One(select = "com.cloth.clothes.dao.StoreDao.findClotheById", fetchType = FetchType.EAGER)),
    })
    Clothdetail findClothesById(String id);

    @Select("select * from user where id = #{id}")
    User findUserById(String id);

    @Select("SELECT * FROM sellout WHERE createDate >= #{startTime} AND createDate <= #{endTime}")
    @Results({
            @Result(property = "subId", column = "subid"),
            @Result(property = "sell", column = "sell"),
            @Result(property = "createData", column = "createData"),
            @Result(property = "clothdetail", column = "clothesDetailId",
                    one = @One(select = "com.cloth.clothes.dao.SellOutDao.findClothesById", fetchType = FetchType.EAGER)),
            @Result(property = "user", column = "userId",
                    one = @One(select = "com.cloth.clothes.dao.SellOutDao.findUserById", fetchType = FetchType.EAGER))
    })
    List<SellOut> findSellOutByData(@Param("startTime") String startTime, @Param("endTime") String endTime);

    @Insert("INSERT INTO sellout(clothesDetailId,sell,userId,number,createDate) values(#{clothesId},#{sell},#{userId},#{number},#{createDate})")
    void insterSellOut(@Param("clothesId") String clothesId, @Param("sell") double sell,
                       @Param("userId") String userId, @Param("number") long number, @Param("createDate") String createDate);
}
