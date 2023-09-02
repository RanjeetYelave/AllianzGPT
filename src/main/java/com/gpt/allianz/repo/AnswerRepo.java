package com.gpt.allianz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpt.allianz.entity.AnswerEntity;

public interface AnswerRepo extends JpaRepository<AnswerEntity, Integer> {

}
