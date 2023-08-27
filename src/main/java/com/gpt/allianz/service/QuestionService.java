package com.gpt.allianz.service;

import java.util.List;

import com.gpt.allianz.DTO.QuestionDTO;
import com.gpt.allianz.Exceptions.ResponseHandler;

public interface QuestionService {

	QuestionDTO getQuestion(Integer QId);

	List<QuestionDTO> getallQuestions();

	QuestionDTO createQuestion(QuestionDTO questionDTO);

	QuestionDTO updateQuestion(Integer QId, QuestionDTO questionDTO);

	ResponseHandler deleteQuestion(Integer QId);
}
