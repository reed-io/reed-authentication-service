/**
 * E5Projects @ org.reed.authentication.dao/PermissionDao.java
 */
package org.reed.authentication.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.reed.authentication.define.Permission;
import java.util.Collection;

/**
 * @author chenxiwen
 * @createTime 2020年03月12日 下午1:50
 * @description
 */
@Mapper
public interface PermissionDao {

    @Select("select * from permission where pid=#{pid}")
    Permission findPermissionById(@Param("pid") String pid);

    @Select("select * from permission where clientId=#{clientId}")
    Collection<Permission> findPermissionsByClientId(@Param("clientId") String clientId);

    @Select("select * from permission where pid in (select pid from role_permission where rid=#{rid})")
    Collection<Permission> findPermissionsByRoleId(@Param("rid") String rid);

    @Select("select * from permission where pid in (select pid from group_permission where gid=#{gid})")
    Collection<Permission> findPermissionsByGroupId(@Param("gid") String gid);

    @Select("select * from permission where pid in (select pid from user_permission where uid=#{userId})")
    Collection<Permission> findPermissionByUserId(@Param("userId") String userId);
}
