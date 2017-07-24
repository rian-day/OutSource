package com.hyh.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyh.entity.Subject;


@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {
	
	List<Subject> findByProfessionId(int professionId);
	
	List<Subject> findById(int id);
	
	List<Subject> findByTypeAndProfessionId(String type,int professionId);
	Page<Subject> findAll(Pageable pageable);
}
