package com.upstart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PermitAllSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // ...

        // see also: https://docs.spring.io/spring-security/site/docs/5.5.3/reference/html5/#csrf-when
        http.csrf().disable();

        // if Spring MVC is on classpath and no CorsConfigurationSource is provided,
        // Spring Security will use CORS configuration provided to Spring MVC
        http.cors(Customizer.withDefaults());
    }



//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//        http.cors().and().csrf().disable();
//
////        http.cors().and();
////
////        http.antMatcher("/**")
////                .authorizeRequests()
////                .antMatchers("/").permitAll()
////                .anyRequest().permitAll()
////                .and().formLogin();
//    }
}

