package com.gpt.allianz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gpt.allianz.entity.QuestionEntity;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Integer> {
	@Query(value = "SELECT * FROM question_entity WHERE question LIKE %:keyword%", nativeQuery = true)
	List<QuestionEntity> searchByKeyword(@Param("keyword") String keyword);
}
