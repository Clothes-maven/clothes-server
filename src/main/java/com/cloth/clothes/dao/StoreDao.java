package com.cloth.clothes.dao;

import com.cloth.clothes.bean.ClothDetailsRequest;
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

    @Select("UPDATE clothdetail SET number = #{number} WHERE id = #{id}")
    void outStore(@Param("id") String id, @Param("number") long number);

    @Select("select * from clothes LIMIT #{start} , #{end}")
    List<Clothes> getClothes(@Param("start") long start, @Param("end") long end);

    @Select("select number FROM clothdetail where id = #{id}")
    int clothesNumber(String id);

    @SelectProvider(type = SqlBuilder.class, method = "findClothdetailSql")
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
    List<Clothdetail> findClothdetail(@Param("uid") String uid, @Param("cid") String cid);

    @Select("SELECT * FROM store WHERE id = #{id}")
    Store findStoreById(@Param("id") String id);

    @Select("SELECT * FROM clothes WHERE id = #{id}")
    Clothes findClotheById(@Param("id") String id);

    @Select("SELECT * FROM store")
    List<Store> getStores();

    @Update("UPDATE clothdetail SET isStopSell = #{isStopSell} WHERE id = #{id}")
    boolean updateSell(@Param("isStopSell") int isStopSell, @Param("id") String id);

    @Delete("DELETE FROM clothdetail WHERE id = #{id}")
    boolean deleteDetails(@Param("id") String id);

    @Insert("insert into clothdetail(size,color,store,number,clothe) values(#{size},#{color},#{storeId},#{number},#{clotheId})")
    boolean insertDetails(ClothDetailsRequest clothDetailsRequest);
}
