package com.hyh.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.SubjectGroup;

public interface SubjectGroupDao extends JpaRepository<SubjectGroup, Long> {
	SubjectGroup findById(int groupid);
	
	Page<SubjectGroup> findByProfessionId(int id ,Pageable pageable);
}
