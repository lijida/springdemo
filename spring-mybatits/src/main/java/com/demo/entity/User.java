package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class User {
	@TableId
	private Long id;
    private String name;
    private Integer age;
    private String email;
    private String state;
}
