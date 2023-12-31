package com.gpt.allianz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gpt.allianz.entity.AnswerEntity;

public interface AnswerRepo extends JpaRepository<AnswerEntity, Integer> {
	@Query("SELECT a FROM AnswerEntity a WHERE a.question.id = :questionId")
	List<AnswerEntity> findAllAnswersByQuestionId(@Param("questionId") int questionId);

	@Query("SELECT a FROM AnswerEntity a WHERE a.question.question LIKE %:keyword%")
	List<AnswerEntity> findAllAnswersByKeyword(String keyword);
}
