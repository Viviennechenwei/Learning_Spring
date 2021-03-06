package com.springlearning.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.springlearning"})
@Import(DBConfiguration.class)
@PropertySource("classpath:application.yml")
public class SpringConfiguration {

}
