package com.gpt.allianz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpt.allianz.DTO.QuestionDTO;
import com.gpt.allianz.Exceptions.ResponseHandler;
import com.gpt.allianz.serviceImpl.QuestionServiceImpl;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionServiceImpl questionService;

	@PostMapping("/create")
	ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
		QuestionDTO createQuestion = questionService.createQuestion(questionDTO);
		return new ResponseEntity<QuestionDTO>(createQuestion, HttpStatus.OK);
	}

	@PutMapping("/update/{QId}")
	ResponseEntity<QuestionDTO> updateQuestion(@PathVariable Integer QId, @RequestBody QuestionDTO questionDTO) {
		QuestionDTO updated = questionService.updateQuestion(QId, questionDTO);
		return new ResponseEntity<QuestionDTO>(updated, HttpStatus.OK);
	}

	@GetMapping("/get/{QId}")
	ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Integer QId) {
		QuestionDTO question = questionService.getQuestion(QId);
		return new ResponseEntity<QuestionDTO>(question, HttpStatus.OK);
	}

	@GetMapping("/get")
	ResponseEntity<List<QuestionDTO>> getAllQuestions() {
		List<QuestionDTO> getallQuestions = questionService.getallQuestions();
		return new ResponseEntity<List<QuestionDTO>>(getallQuestions, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{QId}")
	ResponseEntity<ResponseHandler> deleteQuestion(@PathVariable Integer QId) {
		ResponseHandler response = questionService.deleteQuestion(QId);
		return new ResponseEntity<ResponseHandler>(response, HttpStatus.GONE);
	}

	@GetMapping("/search")
	public List<QuestionDTO> searchQuestions(@RequestParam String keyword) {
		return questionService.searchQuestionsByKeyword(keyword);
	}

}
