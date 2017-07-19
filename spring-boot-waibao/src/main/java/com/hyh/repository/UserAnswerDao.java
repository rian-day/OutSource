package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.UserAnswer;

public interface UserAnswerDao extends JpaRepository<UserAnswer, Long> {

}
