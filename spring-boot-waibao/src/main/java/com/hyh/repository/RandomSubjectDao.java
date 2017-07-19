package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.RandomSubject;

public interface RandomSubjectDao extends JpaRepository<RandomSubject , Long> {
	
}
