package com.echo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GirlController {
	@Autowired
	private GirlRepository girlRepository;
	
	@GetMapping(value="/girls")
	public List<Girl> girllist(){
		return girlRepository.findAll();
		
	}

}
