package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dto.QuestionDto;
import com.demo.entity.Question;
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
	
	@Select("SELECT q.`id` as id ,q.`context`as context,user.`name` as userName FROM t_question q,user WHERE q.id=user.id and user.state <>'0'")
    List<QuestionDto> getQuestionUser(Page<QuestionDto> page);
	
}
