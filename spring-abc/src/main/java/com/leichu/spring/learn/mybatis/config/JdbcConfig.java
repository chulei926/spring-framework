package com.leichu.spring.learn.mybatis.config;

import org.springframework.beans.factory.annotation.Value;

public class JdbcConfig {

	@Value("${url}")
	private String url;
	@Value("${driver}")
	private String driver;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JdbcConfig{" +
				"url='" + url + '\'' +
				", driver='" + driver + '\'' +
				", user='" + user + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
