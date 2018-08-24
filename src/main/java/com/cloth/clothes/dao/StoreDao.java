package com.cloth.clothes.dao;

import com.cloth.clothes.bean.Clothdetail;
import com.cloth.clothes.bean.Clothes;
import com.cloth.clothes.bean.Store;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface StoreDao {

    @Insert("insert into clothes" +
            "(name,feature,brand,type,texture,couar,sleeve,batch,cost,clothesUrl,supplier,pay)"
            + " values "
            + "( "
            + "#{name}, #{feature}, #{brand}, #{type}, #{texture}, #{couar}, #{sleeve}, #{batch}, #{cost}, #{clothesUrl},#{supplier},#{pay}"
            + " )")
    boolean inStore(Clothes clothes);

    @Update("UPDATE clothes SET name = #{name},feature = #{feature},brand = #{brand},type = #{type}," +
            "texture = #{texture},couar = #{couar},sleeve = #{sleeve},batch = #{batch},cost = #{cost},clothesUrl = #{clothesUrl}," +
            "supplier = #{supplier}, pay = #{pay} WHERE id = #{id}")
    boolean modifyStore(Clothes clothes);

    @Select("UPDATE clothes SET number = #{number} WHERE id = #{id}")
    void outStore(@Param("id") String id, @Param("number") long number);

    @Select("select * from clothes WHERE number >0 LIMIT #{start} , #{end}")
    List<Clothes> getClothes(@Param("start") long start, @Param("end") long number);

    @Select("select number FROM clothes where id = #{id}")
    int clothesNumber(String id);

    @SelectProvider(type = SqlBuilder.class,method = "findClothdetailSql")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "size", column = "size"),
            @Result(property = "color", column = "color"),
            @Result(property = "number", column = "number"),
            @Result(property = "store", column = "store",
                    one = @One(select = "com.cloth.clothes.dao.StoreDao.findStoreById", fetchType = FetchType.EAGER)),
    })
    List<Clothdetail> findClothdetail(@Param("uid") String uid, @Param("cid") String cid);

    @Select("SELECT * FROM store WHERE id = #{id}")
    Store findStoreById(@Param("id") String id);
}
