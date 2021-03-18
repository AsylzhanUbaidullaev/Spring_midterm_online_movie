package com.asylzhan.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.asylzhan.spring")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.asylzhan.spring.repo")
public class SpringConfig {
}
