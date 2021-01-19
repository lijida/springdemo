package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dto.PageUtils;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;

@RestController
@RequestMapping("user")
public class UserControllre {
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("queryUser")
	public PageUtils<User> getUser(Integer current, Integer size) {
		PageUtils<User> pu=new PageUtils<User>();
		
		IPage<User> page = new Page<>(current, size);
		userMapper.selectPage(page, null);
		pu.setCurrent(current);
		pu.setSize(size);
		pu.setTotal(page.getTotal());
		pu.setUserList(page.getRecords());
		return pu;
		
	}
}
