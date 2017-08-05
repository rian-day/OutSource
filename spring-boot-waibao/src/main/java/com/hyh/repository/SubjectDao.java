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
	Page<Subject> findByProfessionId(int professionId,Pageable pageable);
	
	Subject findById(int id);
	
	Page<Subject> findByProfessionIdAndContentLike(int professionId,String content,Pageable pageable);
	
	List<Subject> findByTypeAndProfessionId(String type,int professionId);
	Page<Subject> findAll(Pageable pageable);
}
