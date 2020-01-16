package com.leichu.spring.learn.mybatis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.leichu.spring.learn.mybatis.service")
@MyMapperScan("com.leichu.spring.learn.mybatis.mapper")
public class MainConfig {

}
