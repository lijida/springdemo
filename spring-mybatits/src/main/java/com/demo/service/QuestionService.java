package com.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dto.QuestionDto;
import com.demo.entity.Question;

public interface QuestionService extends IService<Question>{
	public Page<QuestionDto> getQuestionUser(Page<QuestionDto> page);
}
