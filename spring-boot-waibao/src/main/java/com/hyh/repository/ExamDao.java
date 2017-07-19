package com.hyh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.Exam;

public interface ExamDao extends JpaRepository<Exam , Long> {
	Page<Exam> findByUserId(int userid ,Pageable pageable);
	Exam findById(int examid);
}
