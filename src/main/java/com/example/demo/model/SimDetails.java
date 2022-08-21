package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="simdetails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SimDetails {
	@Id
	private long id;
	private long phoneno;
	private String status;
	private Date expdate;
	private Date regdate;
	private String kyc;
	private String provider;
	private String fullname;
	
	
}
