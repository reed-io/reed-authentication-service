/**
 * E5Projects @ org.reed.authentication.define/reedAuthenticationErrorCode.java
 */
package org.reed.authentication.define;

import org.reed.define.BaseErrorCode;
import org.reed.define.CodeDescTag;

/**
 * @author chenxiwen
 * @createTime 2020年03月12日 下午3:09
 * @description
 */
public final class ReedAuthenticationErrorCode extends BaseErrorCode {

    @CodeDescTag(desc = "user not found!")
    public static final int USER_NOT_FOUND = 0x1100;

    @CodeDescTag(desc = "username or password is wrong!")
    public static final int USERNAME_OR_PASSWORD_ERROR = 0x1101;

    @CodeDescTag(desc = "username can not be empty!")
    public static final int USERNAME_IS_EMPTY = 0x1102;

    @CodeDescTag(desc = "password can not be empty!")
    public static final int PASSWORD_IS_EMPTY = 0x1103;

    @CodeDescTag(desc = "password is not match!")
    public static final int PASSWORD_NOT_MATCH = 0x1104;

    @CodeDescTag(desc = "appId is not match!")
    public static final int APPID_NOT_MATCH = 0x1105;

}
