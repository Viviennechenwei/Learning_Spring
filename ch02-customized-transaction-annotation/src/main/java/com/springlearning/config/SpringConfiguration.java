package com.springlearning.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.springlearning"})
@Import(DBConfiguration.class)
public class SpringConfiguration {

}
