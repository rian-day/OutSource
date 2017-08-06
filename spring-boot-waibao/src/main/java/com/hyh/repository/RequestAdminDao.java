package com.hyh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.RequestAdmin;

public interface RequestAdminDao extends JpaRepository<RequestAdmin, Long> {
	List<RequestAdmin> findByCorrect(char correct);
}
