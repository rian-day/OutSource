package com.hyh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.SubjectGroup;

public interface SubjectGroupDao extends JpaRepository<SubjectGroup, Long> {
	List<SubjectGroup> findById(int groupid);
}
