/**
 * E5Projects @ org.reed.authentication.controller/AuthenticationController.java
 */
package org.reed.authentication.controller;

import java.util.ArrayList;
import java.util.Collection;
import org.reed.authentication.dao.GroupDao;
import org.reed.authentication.dao.PermissionDao;
import org.reed.authentication.dao.RoleDao;
import org.reed.authentication.dao.UserDao;
import org.reed.authentication.define.Group;
import org.reed.authentication.define.Permission;
import org.reed.authentication.define.ReedAuthenticationErrorCode;
import org.reed.authentication.define.Role;
import org.reed.authentication.define.User;
import org.reed.controller.ReedBaseController;
import org.reed.entity.ReedResult;
import org.reed.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxiwen
 * @createTime 2020年03月11日 下午5:04
 * @description
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController extends ReedBaseController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private GroupDao groupDao;

    @PostMapping("permissions/{userId}")
    public ReedResult<Collection<Permission>> getUserPermissions(@PathVariable String userId) {
        ReedResult<Collection<Permission>> result = new ReedResult<>();
        Collection<Permission> permissions = new ArrayList<Permission>();
        Collection<Group> groups = groupDao.findGroupsByUserId(userId);
        Collection<Role> roles = roleDao.findRolesByUserId(userId);
        groups.stream().forEach(item -> {
            Collection<Role> groupRoles = roleDao.findRolesByGroupId(item.getGid());
            if (!CollectionUtils.isEmpty(groupRoles)) {
                roles.addAll(groupRoles);
            }
        });
        Collection<Permission> userPermissions = permissionDao.findPermissionByUserId(userId);
        roles.stream().forEach(item -> {
            Collection<Permission> rolePermissions =
                    permissionDao.findPermissionsByRoleId(item.getRid());
            if (!CollectionUtils.isEmpty(rolePermissions)) {
                permissions.addAll(rolePermissions);
            }
        });
        groups.stream().forEach(item -> {
            Collection<Permission> groupPermissions =
                    permissionDao.findPermissionsByGroupId(item.getGid());
            if (!CollectionUtils.isEmpty(groupPermissions)) {
                permissions.addAll(groupPermissions);
            }
        });
        if (!CollectionUtils.isEmpty(userPermissions)) {
            permissions.addAll(userPermissions);
        }
        result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
        result.setData(permissions);
        return result;
    }


    @PostMapping("/user")
    public ReedResult<User> getToken(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        ReedResult<User> result = new ReedResult<>();
        if (StringUtil.isEmpty(username)) {
            result.setCode(ReedAuthenticationErrorCode.USERNAME_IS_EMPTY);
            return result;
        }
        if (StringUtil.isEmpty(password)) {
            result.setCode(ReedAuthenticationErrorCode.PASSWORD_IS_EMPTY);
            return result;
        }
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            result.setCode(ReedAuthenticationErrorCode.USER_NOT_FOUND);
            return result;
        }
        if (!user.getPassword().equals(password)) {
            result.setCode(ReedAuthenticationErrorCode.PASSWORD_NOT_MATCH);
            return result;
        }
        result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
        result.setData(user);
        return result;
    }

    @Override
    public String version() {
        return "";
    }
}
