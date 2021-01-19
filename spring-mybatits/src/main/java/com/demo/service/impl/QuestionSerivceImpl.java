package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dto.QuestionDto;
import com.demo.entity.Question;
import com.demo.mapper.QuestionMapper;
import com.demo.service.QuestionService;

@Service
public class QuestionSerivceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
	  	@Override
	    public Page<QuestionDto> getQuestionUser(Page<QuestionDto> page) {
	        return page.setRecords(this.baseMapper.getQuestionUser(page));
	    }
}
