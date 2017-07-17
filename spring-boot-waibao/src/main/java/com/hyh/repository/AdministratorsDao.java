package com.hyh.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyh.entity.Administrators;
import com.hyh.entity.UserInfo;
@Repository
public interface AdministratorsDao extends JpaRepository<Administrators, Long> {
	
	ArrayList<Administrators> findByName(String Name);
	
	ArrayList<Administrators> findByMailAndPassword(String Mail,String Password);
	
	//分页
	Page<Administrators> findByName(String Name,Pageable pageable);
}
