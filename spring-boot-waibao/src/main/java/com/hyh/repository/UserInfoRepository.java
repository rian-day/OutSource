package com.hyh.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hyh.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	ArrayList<UserInfo> findByName(String name);
	
	ArrayList<UserInfo> findByMailAndPassword(String mail,String password);
	
	//分页
	Page<UserInfo> findByNameNot(String name,Pageable pageable);
	
	@Query("from UserInfo u where u.name=:name")
    UserInfo findUser(@Param("name") String name);
}
