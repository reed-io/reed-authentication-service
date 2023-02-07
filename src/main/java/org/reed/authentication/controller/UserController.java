/**
 * E5Projects @ org.reed.authentication.controller/UserController.java
 */
package org.reed.authentication.controller;

import java.util.Collection;
import org.reed.authentication.dao.UserDao;
import org.reed.authentication.define.ReedAuthenticationErrorCode;
import org.reed.authentication.define.User;
import org.reed.controller.ReedBaseController;
import org.reed.entity.ReedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxiwen
 * @createTime 2020年03月12日 下午2:22
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController extends ReedBaseController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/id/{userId}")
    public ReedResult<User> getUserById(@PathVariable("userId") String userId) {
        ReedResult<User> result = new ReedResult<>();
        User user = userDao.findUserById(userId);
        if (user == null) {
            result.setCode(ReedAuthenticationErrorCode.USER_NOT_FOUND);
            return result;
        } else {
            result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
            result.setData(user);
            return result;
        }
    }

    @RequestMapping("/username/{username}")
    public ReedResult<User> getUserByUsername(@PathVariable("username") String username) {
        ReedResult<User> result = new ReedResult<>();
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            result.setCode(ReedAuthenticationErrorCode.USER_NOT_FOUND);
            return result;
        } else {
            result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
            result.setData(user);
            return result;
        }
    }

    @RequestMapping("/group/{gid}")
    public ReedResult<Collection<User>> getGroupUsersByGroupId(@PathVariable("gid") String gid) {
        ReedResult<Collection<User>> result = new ReedResult<>();
        Collection<User> users = userDao.findUsersByGroupId(gid);
        if (users == null || users.size() == 0) {
            result.setCode(ReedAuthenticationErrorCode.USER_NOT_FOUND);
            return result;
        } else {
            result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
            result.setData(users);
            return result;
        }
    }



    @Override
    public String version() {
        return "V1";
    }


}
