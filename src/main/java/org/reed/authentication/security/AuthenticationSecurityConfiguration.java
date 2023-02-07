/**
 * E5Projects @ org.reed.authentication.security/AuthenticationSecurityConfiguration.java
 */
package org.reed.authentication.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chenxiwen
 * @createTime 2020年03月12日 下午3:30
 * @description
 */
@Configuration
public class AuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
        ;
    }
}
