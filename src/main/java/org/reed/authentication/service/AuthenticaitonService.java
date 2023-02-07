/**
 * AuthenticaitonService.java Create on 2020年4月28日
 * 
 * Copyright (c) 2020年4月28日 reed, All rights reserved.
 * 
 * @author languangsheng
 * @version 1.0
 * 
 */
/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @time 2020年4月28日 上午9:54:19
 *
 */
package org.reed.authentication.service;

import org.reed.entity.ReedResult;
import com.alibaba.fastjson2.JSONObject;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @time 2020年4月28日 上午9:54:19
 *
 */
public interface AuthenticaitonService {
    ReedResult<JSONObject> getPermissionByUserId(String userId, String appCode);

    ReedResult<JSONObject> getPermissionByRole(String roleId, String appCode);

    ReedResult<JSONObject> getPermissionByGroup(String groupId, String appCode);

    ReedResult<JSONObject> getPermissionByUser(String userId, String appCode);
}
