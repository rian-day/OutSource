package com.hyh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.RandomSubject;

public interface RandomSubjectDao extends JpaRepository<RandomSubject , Long> {
	List<RandomSubject> findByProfessionId(int id);
	List<RandomSubject> findByProfessionIdAndType(int id,String type);
}
