package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.SimDetails;
import com.example.demo.repository.SimDetailsRepo;


@RestController
@RequestMapping("/api")
public class SimController {
	
	@Autowired
	private SimDetailsRepo repository;
	
	
	private RestTemplate restTemplate;
	public String renewValidity(SimDetails simdetails) {
		try {
			restTemplate=new RestTemplate();
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.APPLICATION_JSON);
	      HttpEntity<SimDetails> entity = new HttpEntity<SimDetails>(simdetails,headers);

	      return restTemplate.exchange("https://example.com/endpoint", HttpMethod.POST, entity, String.class).getBody();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	@GetMapping("/")
	public String home() {
		return "welcome to sim-card-api";
	}
	
	@PostMapping("/add")
	public SimDetails addSimDetails(@RequestBody SimDetails simdetails) {
		return repository.save(simdetails);
	}
	@GetMapping("/listall")
	public List<SimDetails> getAllSimDetails(){
		return repository.findAll();
	}
	@PutMapping("/{id}")
	public SimDetails updateSimDetails(@RequestBody SimDetails simdetails,@PathVariable Long id) {
		return repository.findById(id).map(details->{
			details.setExpdate(simdetails.getExpdate());
			details.setFullname(simdetails.getFullname());
			details.setKyc(simdetails.getKyc());
			details.setPhoneno(simdetails.getPhoneno());
			details.setProvider(simdetails.getProvider());
			details.setRegdate(simdetails.getRegdate());
			details.setStatus(simdetails.getStatus());
			return repository.save(details);
			}).orElseGet(()->{
			simdetails.setId(id);
			return repository.save(simdetails);
		});
	}
	@DeleteMapping("/{id}")
	public void deleteSimDetails(@PathVariable Long id) {
		repository.deleteById(id);
	}
	@GetMapping("/to-renew")
	public List<SimDetails> toRenew(){
		return repository.renewList();
	}
	@PutMapping("/renew/{id}")
	public SimDetails renewAnId(@RequestBody SimDetails simdetails,@PathVariable Long id) {
		
		return repository.findById(id).map(details->{
			details.setExpdate(simdetails.getExpdate());
			details.setFullname(simdetails.getFullname());
			details.setKyc(simdetails.getKyc());
			details.setPhoneno(simdetails.getPhoneno());
			details.setProvider(simdetails.getProvider());
			details.setRegdate(simdetails.getRegdate());
			details.setStatus(simdetails.getStatus());
			renewValidity(details);
			return repository.save(details);
			}).orElseGet(()->{
			simdetails.setId(id);
			return repository.save(simdetails);
		});
	}

}
