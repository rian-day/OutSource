package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.Message;

public interface MessageDao extends JpaRepository<Message, Long> {
	
}
