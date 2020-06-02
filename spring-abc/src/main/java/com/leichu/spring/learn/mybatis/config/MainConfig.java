package com.leichu.spring.learn.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@ComponentScan("com.leichu.spring.learn.mybatis.service")
//@MyMapperScan("com.leichu.spring.learn.mybatis.mapper")
@MapperScan("com.leichu.spring.learn.mybatis.mapper")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class MainConfig {

	@Bean
	public JdbcConfig jdbcConfig() {
		return new JdbcConfig();
	}

	@Bean
	public DataSource dataSource(JdbcConfig jdbcConfig) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(jdbcConfig.getUser());
		dataSource.setPassword(jdbcConfig.getPassword());
		dataSource.setUrl(jdbcConfig.getUrl());
		dataSource.setDriverClassName(jdbcConfig.getDriver());
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
