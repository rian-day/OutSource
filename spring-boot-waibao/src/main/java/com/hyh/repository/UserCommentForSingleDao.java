package com.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyh.entity.UserCommentForSingle;

public interface UserCommentForSingleDao extends JpaRepository<UserCommentForSingle, Long> {

}
