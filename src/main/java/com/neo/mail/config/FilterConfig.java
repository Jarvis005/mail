package com.neo.mail.config;

import com.neo.mail.interceptor.CrosFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by my on 2019/4/16.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CrosFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
