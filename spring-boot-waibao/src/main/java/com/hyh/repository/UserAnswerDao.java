package com.hyh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.UserAnswer;

public interface UserAnswerDao extends JpaRepository<UserAnswer, Long> {
	UserAnswer findById(int id);
	Page<UserAnswer> findByUserId(int userId,Pageable pageable);
}
