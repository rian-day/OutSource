package com.hyh.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyh.entity.Administrators;
@Repository
public interface AdministratorsDao extends JpaRepository<Administrators, Long> {
	Administrators findById(int id);
	List<Administrators> findByName(String Name);
	
	List<Administrators> findByMailAndPassword(String Mail,String Password);
	List<Administrators> findByMail(String Mail);
	//分页
	Page<Administrators> findByName(String Name,Pageable pageable);
}
