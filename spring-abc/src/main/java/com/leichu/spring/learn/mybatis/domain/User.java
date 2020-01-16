package com.leichu.spring.learn.mybatis.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class User {

	private String id;
	private String name;
	private String pwd;

}
