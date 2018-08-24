package com.cloth.clothes.dao;

import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.annotations.Param;

public class SqlBuilder {

    public String findClothdetailSql(@Param("uid") String uid, @Param("cid") String cid) {
        String sql = "SELECT * FROM clothdetail as c join store as s on c.store = s.id where ";
        if (StringUtils.isNullOrEmpty(uid)) {
            sql = sql.concat("c.clothe = #{cid}");
        } else {
            sql = sql.concat("c.clothe = #{cid} AND c.store = #{uid}");
        }
        return sql;
    }
}
