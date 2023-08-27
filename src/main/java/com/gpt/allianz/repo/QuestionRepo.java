package com.gpt.allianz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gpt.allianz.entity.QuestionEntity;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Integer> {

}
