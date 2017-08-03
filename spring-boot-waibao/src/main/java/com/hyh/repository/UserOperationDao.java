package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.UserOperation;

public interface UserOperationDao extends JpaRepository<UserOperation, Long> {

}
