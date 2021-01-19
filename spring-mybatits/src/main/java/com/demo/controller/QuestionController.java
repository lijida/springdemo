package com.demo.controller;

import com.demo.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dto.PageUtils;
import com.demo.dto.QuestionDto;
import com.demo.service.QuestionService;
@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("getUserQuestion")
	public PageUtils<QuestionDto> getUserQuestions(Integer current, Integer size){
		PageUtils<QuestionDto> pu=new PageUtils<>();
		Page<QuestionDto> page = new Page<>(current, size);
		questionService.getQuestionUser(page);
		pu.setCurrent(current);
		pu.setSize(size);
		pu.setTotal(page.getTotal());
		pu.setUserList(page.getRecords());
		return pu;
	}
}
