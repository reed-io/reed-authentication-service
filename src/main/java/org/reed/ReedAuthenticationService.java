/**
 * E5Projects @ org.reed/reedAuthenticationService.java
 */
package org.reed;

import org.reed.bootup.ReedStarter;
import org.reed.bootup.SpringBootBootup;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author chenxiwen
 * @createTime 2020年03月11日 上午10:43
 * @description
 */
// @EnableServiceRegister
// @EnableServiceTrace
// @EnableAdminClient
// @reedUnifiedConfig
// @EnableDiscoveryClient
public class ReedAuthenticationService extends SpringBootBootup {

    public static final String MODULE_NAME = "REED-AUTHENTICATION-SERVICE";

    @Override
    protected void beforeStart() {
        ReedStarter.putArgs("server.port", "9000");
        // reedStarter.putArgs("eureka.instance.prefer-ip-address", "true");
        // reedStarter.putArgs("eureka.instance.ip-address",
        // "http://ip.port/reed-authentication-service");
    }

    @Override
    protected void afterStart(SpringApplication application, ApplicationContext context) {

    }

    public static void main(String[] args) {
        new ReedAuthenticationService().start(args);
    }

    /**
     * @return Project/Module Name
     */
    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }
}
