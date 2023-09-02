package com.gpt.allianz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpt.allianz.DTO.AnswerDTO;
import com.gpt.allianz.Exceptions.ResponseHandler;
import com.gpt.allianz.serviceImpl.AnswerServiceImpl;

@RestController
@RequestMapping("/api")
public class AnswerController {
	@Autowired
	AnswerServiceImpl answerService;

	@PostMapping("/answer/create")
	ResponseEntity<AnswerDTO> createAnswer(@RequestBody AnswerDTO answerDTO, @RequestParam Integer QuestionId) {
		AnswerDTO createdAnswer = answerService.createAnswer(answerDTO, QuestionId);
		return new ResponseEntity<AnswerDTO>(createdAnswer, HttpStatus.OK);
	}

	@GetMapping("/answer")
	ResponseEntity<List<AnswerDTO>> getAllAnswers() {
		List<AnswerDTO> getallAnswers = answerService.getallAnswers();
		return new ResponseEntity<List<AnswerDTO>>(getallAnswers, HttpStatus.OK);
	}

	@GetMapping("/answer/{questionId}")
	public List<AnswerDTO> findAllAnswersByQuestionId(@PathVariable int questionId) {
		return answerService.findAllAnswersByQuestionId(questionId);
	}

	@DeleteMapping("/answer/delete")
	ResponseEntity<ResponseHandler> deleteAnswer(@RequestParam Integer answerId) {
		ResponseHandler deletedResponse = answerService.deleteAnswer(answerId);
		return new ResponseEntity<ResponseHandler>(deletedResponse, HttpStatus.OK);
	}
}
