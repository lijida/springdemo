package com.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageUtils<T> {
	private Integer current;
	private Integer size;
	private Long total;
	private List<T> userList;
}
