/**
 * E5Projects @ org.reed.authentication.dao/RoleDao.java
 */
package org.reed.authentication.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.reed.authentication.define.Role;
import java.util.Collection;

/**
 * @author chenxiwen
 * @createTime 2020年03月11日 下午6:36
 * @description
 */
@Mapper
public interface RoleDao {

    @Select("select * from role where rid=#{rid}")
    Role findRoleById(@Param("rid") String rid);

    @Select("select * from role where clientId=#{clientId}")
    Collection<Role> findRolesByClientId(@Param("clientId") String clientId);

    @Select("select * from role where rid in (select rid from user_role where uid=#{userId})")
    Collection<Role> findRolesByUserId(@Param("userId") String userId);

    @Select("select * from role where rid in (select rid from group_role where gid=#{gid})")
    Collection<Role> findRolesByGroupId(@Param("gid") String gid);

    @Select("select * from role where rid in (select rid from user_permission where pid=#{pid})")
    Collection<Role> findRolesByPermissionId(@Param("pid") String pid);

    @Insert("insert into role(rid, clientId, desc) values(#{role.rid}, #{role.clientId}, #{role.desc})")
    int addRole(@Param("role") Role role);


}
