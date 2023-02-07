/**
 * E5Projects @ org.reed.authentication.define/reedApp.java
 */
package org.reed.authentication.define;

/**
 * @author chenxiwen
 * @createTime 2020年03月25日 下午2:42
 * @description
 */
public class ReedApp {

    private String appId;
    private String secret;
    private String name;
    private String desc;
    private String serviceUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    @Override
    public String toString() {
        return "ReedApp{" + "appId='" + appId + '\'' + ", secret='" + secret + '\'' + ", name='"
                + name + '\'' + ", desc='" + desc + '\'' + ", serviceUrl='" + serviceUrl + '\''
                + '}';
    }
}
