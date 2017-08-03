package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.AdminOperation;

public interface AdminOperationDao extends JpaRepository<AdminOperation, Long> {
	
}
