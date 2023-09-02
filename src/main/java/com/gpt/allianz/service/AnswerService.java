package com.gpt.allianz.service;

import java.util.List;

import com.gpt.allianz.DTO.AnswerDTO;
import com.gpt.allianz.Exceptions.ResponseHandler;

public interface AnswerService {
	AnswerDTO createAnswer(AnswerDTO answerDTO, Integer QuestionId);
	// answerUpdationisForbiddenByDefault
	// AnswerDTO updateAnswerDTO(AnswerDTO anseAnswerDTO, Integer answerId);

	// AnswerCanBeOnlyFetchedWithQuestion
	// AnswerDTO getAnswer(Integer answeId);

	List<AnswerDTO> getallAnswers();

	ResponseHandler deleteAnswer(Integer answerId);
}
