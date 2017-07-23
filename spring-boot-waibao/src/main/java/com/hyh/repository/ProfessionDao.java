package com.hyh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyh.entity.Profession;
@Repository
public interface ProfessionDao extends JpaRepository<Profession, Long> {
	
	List<Profession> findByName(String Name);
	Profession findById(int id);
}
