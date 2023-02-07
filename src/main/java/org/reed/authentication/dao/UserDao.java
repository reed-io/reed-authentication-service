/**
 * E5Projects @ org.reed.authentication/UserDao.java
 */
package org.reed.authentication.dao;

import org.apache.ibatis.annotations.*;
import org.reed.authentication.define.User;
import java.util.Collection;

/**
 * @author chenxiwen
 * @createTime 2020年03月11日 下午6:01
 * @description
 */
@Mapper
public interface UserDao {

    @Select("select * from user where userId=#{userId}")
    User findUserById(@Param("userId") String userId);

    @Select("select * from user where username=#{username}")
    User findUserByUsername(@Param("username") String username);

    @Select("select * from user where userId in(select uid from user_group where gid=#{gid})")
    Collection<User> findUsersByGroupId(@Param("gid") String gid);

    @Select("select * from user where userId in(select uid from user_role where rid=#{rid})")
    Collection<User> findUsersByRoleId(@Param("rid") String rid);

    @Insert("insert into user(userId, username, password, email, mobileNumber, idCard) values(#{user.userId}," +
            "#{user.username}, #{user.password}, #{user.password}, #{user.email}, #{user.mobileNumber}, #{user.idCard})")
    int addUser(@Param("user") User user);

    @Update("update user set username=#{user.username}, password=#{user.password}, " +
            "email=#{user.email}, mobileNumber=#{user.mobileNumber}, idCard=#{idCard} where userId=#{user.userId}")
    int modifyUser(@Param("user") User user);
}
