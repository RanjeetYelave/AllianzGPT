package com.gpt.allianz.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpt.allianz.DTO.QuestionDTO;
import com.gpt.allianz.Exceptions.NotFoundEx;
import com.gpt.allianz.Exceptions.ResponseHandler;
import com.gpt.allianz.entity.AnswerEntity;
import com.gpt.allianz.entity.QuestionEntity;
import com.gpt.allianz.repo.AnswerRepo;
import com.gpt.allianz.repo.QuestionRepo;
import com.gpt.allianz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo questionRepo;

	@Autowired
	AnswerRepo answerRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AnswerServiceImpl answerService;

	@Override
	public QuestionDTO getQuestion(Integer QId) {
		QuestionEntity foundQuestion = questionRepo.findById(QId)
				.orElseThrow(() -> new NotFoundEx("Question Not Found 404", false));
		QuestionDTO questiondto = modelMapper.map(foundQuestion, QuestionDTO.class);
		return questiondto;
	}

	@Override
	public List<QuestionDTO> getallQuestions() {
		List<QuestionEntity> allQuestionEntities = questionRepo.findAll();
		List<QuestionDTO> allQuestionDTOs = allQuestionEntities.stream()
				.map(Qentity -> modelMapper.map(Qentity, QuestionDTO.class)).collect(Collectors.toList());
		return allQuestionDTOs;
	}

	@Override
	public QuestionDTO createQuestion(QuestionDTO questionDTO) {
		QuestionEntity questionEntity = modelMapper.map(questionDTO, QuestionEntity.class);
		QuestionEntity saved = questionRepo.save(questionEntity);
		return modelMapper.map(saved, QuestionDTO.class);
	}

	@Override
	public QuestionDTO updateQuestion(Integer QId, QuestionDTO questionDTO) {
		QuestionEntity questionEntity = questionRepo.findById(QId)
				.orElseThrow(() -> new NotFoundEx("404 not found", false));
		questionEntity.setQuestion(questionDTO.getQuestion());
		questionEntity.setTime(questionDTO.getTime());
		questionEntity.setDate(questionDTO.getDate());
		QuestionEntity savedEntity = questionRepo.save(questionEntity);
		return modelMapper.map(savedEntity, QuestionDTO.class);
	}

	@Override
	public ResponseHandler deleteQuestion(Integer QId) {
		QuestionEntity questionEntity = questionRepo.findById(QId)
				.orElseThrow(() -> new NotFoundEx("404 not found", false));
		questionRepo.delete(questionEntity);
		return new ResponseHandler("Question Deleted", true);
	}

	public List<QuestionDTO> searchQuestionsByKeyword(String keyword) {
		List<QuestionEntity> searchByKeyword = questionRepo.searchByKeyword(keyword);
		List<QuestionDTO> listofDtos = searchByKeyword.stream()
				.map(Qentity -> modelMapper.map(Qentity, QuestionDTO.class)).collect(Collectors.toList());
		return listofDtos;

	}

	public List<AnswerEntity> allQnaByKeywords(String Keyword) {
		List<AnswerEntity> findAllAnswersByKeyword = answerRepo.findAllAnswersByKeyword(Keyword);
		return findAllAnswersByKeyword;
	}

}
