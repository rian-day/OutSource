package com.hyh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hyh.entity.Subject;


@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {
	
	List<Subject> findByProfessionId(int professionId);
}
