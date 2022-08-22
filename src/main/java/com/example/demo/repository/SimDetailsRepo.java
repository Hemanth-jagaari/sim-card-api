package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.SimDetails;

public interface SimDetailsRepo extends JpaRepository<SimDetails,Long> {

	@Query(value="SELECT s FROM SimDetails s WHERE s.expdate BETWEEN CURRENT_DATE AND CURRENT_DATE+30")
	public List<SimDetails> renewList();
}
