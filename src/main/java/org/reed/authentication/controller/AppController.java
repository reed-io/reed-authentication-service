/**
 * E5Projects @ org.reed.authentication.controller/AppController.java
 */
package org.reed.authentication.controller;

import org.reed.authentication.dao.ReedAppDao;
import org.reed.authentication.define.ReedApp;
import org.reed.authentication.define.ReedAuthenticationErrorCode;
import org.reed.controller.ReedBaseController;
import org.reed.entity.ReedResult;
import org.reed.log.ReedLogger;
import org.reed.utils.EnderUtil;
import org.reed.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxiwen
 * @createTime 2020年03月25日 下午2:50
 * @description
 */
@RestController
@RequestMapping("/app")
public class AppController extends ReedBaseController {

    @Autowired
    private ReedAppDao reedAppDao;

    @Override
    public String version() {
        return "V1";
    }

    @PostMapping("/create")
    public ReedResult<String> createApp(@RequestParam("app_id") String appId,
            @RequestParam("secret") String secret, @RequestParam("name") String name,
            @RequestParam("desc") String desc, @RequestParam("service_url") String serviceUrl) {
        ReedResult<String> result = new ReedResult<>();
        if (StringUtil.isEmpty(appId)) {
            result.setCode(-1);
            result.setMessage("app_id can not be empty!");
            return result;
        }
        if (StringUtil.isEmpty(secret)) {
            result.setCode(-1);
            result.setMessage("secret can not be empty!");
            return result;
        }
        if (StringUtil.isEmpty(name)) {
            result.setCode(-1);
            result.setMessage("name can not be empty!");
            return result;
        }
        // if(StringUtil.isEmpty(desc)){
        // result.setCode(-1);
        // result.setMessage("desc can not be empty!");
        // return result;
        // }
        if (StringUtil.isEmpty(serviceUrl)) {
            result.setCode(-1);
            result.setMessage("service_url can not be empty!");
            return result;
        }
        if (!StringUtil.isUrl(serviceUrl)) {
            result.setCode(-1);
            result.setMessage("service_url is invalidate!");
            return result;
        }
        // TODO 按照协议验证serviceUrl,暂略

        int insertCount = reedAppDao.createApp(appId, secret, name, desc, serviceUrl);
        if (insertCount == 1) {
            result.setCode(0);
            return result;
        } else {
            result.setCode(-1);
            result.setMessage("insert failed!");
            return result;
        }
    }

    @PostMapping("/{app_id}/verify")
    public ReedResult<String> verifyApp(@PathVariable("app_id") String appId,
            @RequestParam("secret") String secret) {
        ReedResult<String> result = new ReedResult<>();
        if (StringUtil.isEmpty(secret)) {
            result.setCode(ReedAuthenticationErrorCode.PASSWORD_IS_EMPTY);
            return result;
        }
        ReedLogger.debug(EnderUtil.devInfo() + " - appId=" + appId);
        ReedLogger.debug(EnderUtil.devInfo() + " - secret=" + secret);
        ReedApp reedApp = reedAppDao.findAppById(appId);
        if (reedApp == null) {
            result.setCode(ReedAuthenticationErrorCode.APPID_NOT_MATCH);
            return result;
        } else {
            if (!reedApp.getSecret().equals(secret)) {
                result.setCode(ReedAuthenticationErrorCode.PASSWORD_NOT_MATCH);
            } else {
                result.setCode(ReedAuthenticationErrorCode.SUCCESS_OPERATE);
            }
            return result;
        }
    }

}
