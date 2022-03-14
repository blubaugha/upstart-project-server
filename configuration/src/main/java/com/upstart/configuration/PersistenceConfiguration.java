package com.upstart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfiguration {
//    @Bean
//    public RepositoryRestConfigurer repositoryRestConfigurer() {
//        return new RepositoryRestConfigurer() {
//            @Override
//            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//                cors.addMapping("/**")
//                        .allowedOrigins("http://localhost:4300");
//            }
//        };
//    }
}
