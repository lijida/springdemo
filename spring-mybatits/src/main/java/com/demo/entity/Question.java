package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
@Data
public class Question {
	@TableId
	private Long id;
    private String context;
    private Long userId;
}
