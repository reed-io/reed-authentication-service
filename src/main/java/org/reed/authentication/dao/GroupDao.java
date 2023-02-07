/**
 * E5Projects @ org.reed.authentication.dao/GroupDao.java
 */
package org.reed.authentication.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.reed.authentication.define.Group;
import java.util.Collection;

/**
 * @author chenxiwen
 * @createTime 2020年03月12日 上午11:05
 * @description
 */
@Mapper
public interface GroupDao {

    @Select("select * from `group` where gid=#{gid}")
    Group findGroupById(@Param("gid") String gid);

    @Select("select * from `group` where gid in (select gid from user_group where uid=#{userId})")
    Collection<Group> findGroupsByUserId(@Param("userId") String userId);

    @Select("select * from `group` where gid in (select gid from group_role where rid=#{rid})")
    Collection<Group> findGroupsByRoleId(@Param("rid") String rid);

    @Select("select * from `group` where gid in (select gid from group_permission where pid=#{pid})")
    Collection<Group> findGroupsByPermissionId(@Param("pid") String pid);

    @Select("select * from `group` where clientId=#{clientId}")
    Collection<Group> findGroupsByClientId(@Param("clientId") String clientId);
}
