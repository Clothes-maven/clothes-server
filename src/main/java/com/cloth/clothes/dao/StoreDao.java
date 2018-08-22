package com.cloth.clothes.dao;

import com.cloth.clothes.bean.Clothes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreDao {

    @Insert("insert into clothes" +
            "(name,feature,brand,type,size,texture,couar,sleeve,batch,cost,number,profit,clothesUrl)"
            + " values "
            + "( "
            + "#{name}, #{feature}, #{brand}, #{type}, #{size}, #{texture}, #{couar}, #{sleeve}, #{batch}, #{cost}, #{number}, #{profit}, #{clothesUrl}"
            + " )")
    boolean inStore(Clothes clothes);

    @Update("UPDATE clothes SET name = #{name},feature = #{feature},brand = #{brand},type = #{type},size = #{size}," +
            "texture = #{texture},couar = #{couar},sleeve = #{sleeve},batch = #{batch},cost = #{cost},number = #{number}," +
            "profit = #{profit} WHERE id = #{id}")
    boolean modifyStore(Clothes clothes);

    @Select("UPDATE clothes SET number = #{number} WHERE id = #{id}")
    void outStore(@Param("id") String id, @Param("number") long number);

    @Select("select * from clothes LIMIT #{start} , #{end}")
    List<Clothes> getClothes(@Param("start") long start, @Param("end") long number);

    @Select("select number FROM clothes where id = #{id}")
    int clothesNumber(String id);
}
