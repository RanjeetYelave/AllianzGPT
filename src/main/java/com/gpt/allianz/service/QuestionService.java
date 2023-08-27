package com.gpt.allianz.service;

import java.util.List;

import com.gpt.allianz.DTO.QuestionDTO;
import com.gpt.allianz.Exceptions.ResponseHandler;

public interface QuestionService {
//get
	QuestionDTO getQuestion(Integer QId);

//getall
	List<QuestionDTO> getallQuestions();

//create
	QuestionDTO createQuestion(QuestionDTO questionDTO);

//update
	QuestionDTO updateQuestion(Integer QId, QuestionDTO questionDTO);

//delete	
	ResponseHandler deleteQuestion(Integer QId);
}
