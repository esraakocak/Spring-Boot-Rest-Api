package com.example.homework2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homework2.core.utilities.results.DataResult;
import com.example.homework2.core.utilities.results.Result;
import com.example.homework2.model.Personnel;
import com.example.homework2.service.abstracts.PersonnelService;


@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {
	

	private PersonnelService personnelService;
	@Autowired
	public PersonnelController( PersonnelService personnelService) {
		this.personnelService=personnelService;
	}
	
  
	
	@GetMapping("/getAll") 
	public DataResult<List<Personnel>> getAll() {
		return this.personnelService.getAll();
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody Personnel personnel) {
		 return this.personnelService.add(personnel);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Personnel personnel) {
		 return this.personnelService.update(personnel);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Personnel personnel) {
		return this.personnelService.delete(personnel)	;	
	}
}
