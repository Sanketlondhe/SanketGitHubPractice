package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hostels;

public interface HostelsRepository extends JpaRepository<Hostels, Integer>  {
	
	

}
