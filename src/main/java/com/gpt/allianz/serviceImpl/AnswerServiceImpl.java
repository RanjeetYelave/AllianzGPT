package com.gpt.allianz.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpt.allianz.DTO.AnswerDTO;
import com.gpt.allianz.Exceptions.NotFoundEx;
import com.gpt.allianz.Exceptions.ResponseHandler;
import com.gpt.allianz.entity.AnswerEntity;
import com.gpt.allianz.entity.QuestionEntity;
import com.gpt.allianz.repo.AnswerRepo;
import com.gpt.allianz.repo.QuestionRepo;
import com.gpt.allianz.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerRepo answerRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	QuestionRepo questionRepo;

	@Override
	public AnswerDTO createAnswer(AnswerDTO answerDTO, Integer QuestionId) {
		AnswerEntity answerEntity = modelMapper.map(answerDTO, AnswerEntity.class);
		QuestionEntity foundQuestionEntity = questionRepo.findById(QuestionId)
				.orElseThrow(() -> new NotFoundEx("Question Not found", false));
		answerEntity.setQuestion(foundQuestionEntity);
		AnswerEntity savedAnswerEntity = answerRepo.save(answerEntity);
		return modelMapper.map(savedAnswerEntity, AnswerDTO.class);
	}

	@Override
	public ResponseHandler deleteAnswer(Integer answerId) {
		AnswerEntity foundAnswerById = answerRepo.findById(answerId)
				.orElseThrow(() -> new NotFoundEx("404 NOT FOUND", false));
		answerRepo.delete(foundAnswerById);
		return new ResponseHandler("Answer Deleted", true);
	}

	@Override
	public List<AnswerDTO> getallAnswers() {
		List<AnswerEntity> allAnswerEntities = answerRepo.findAll();
		List<AnswerDTO> allAnswerDTOs = allAnswerEntities.stream()
				.map(eachAnswer -> modelMapper.map(eachAnswer, AnswerDTO.class)).collect(Collectors.toList());
		return allAnswerDTOs;
	}

	public List<AnswerDTO> findAllAnswersByQuestionId(int questionId) {
		List<AnswerEntity> findAllAnswersByQuestionId = answerRepo.findAllAnswersByQuestionId(questionId);
		List<AnswerDTO> listofAnswerDTOs = findAllAnswersByQuestionId.stream()
				.map(eachAnswer -> modelMapper.map(eachAnswer, AnswerDTO.class)).collect(Collectors.toList());
		return listofAnswerDTOs;
	}

}
