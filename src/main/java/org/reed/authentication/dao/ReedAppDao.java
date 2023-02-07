/**
 * E5Projects @ org.reed.authentication.dao/reedAppDao.java
 */
package org.reed.authentication.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.reed.authentication.define.ReedApp;

/**
 * @author chenxiwen
 * @createTime 2020年03月25日 下午2:45
 * @description
 */
@Mapper
public interface ReedAppDao {

    @ResultType(ReedApp.class)
    @Select("select * from app where appId=#{appId}")
    ReedApp findAppById(@Param("appId") String appId);

    @Insert("insert into app(`appId`, `secret`, `name`, `desc`, `serviceUrl`) values(#{appId}, #{secret}, #{name}, #{desc}, #{serviceUrl})")
    int createApp(@Param("appId") String appId, @Param("secret") String secret,
            @Param("name") String name, @Param("desc") String desc,
            @Param("serviceUrl") String serviceUrl);


}
