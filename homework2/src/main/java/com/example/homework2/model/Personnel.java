package com.example.homework2.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "personnel")
public class Personnel {


	
	@Id
	private String id ;
	
    
	private String name;
	private String surname;
	private String sex;
	
	private String mobile;
	private String address;
	


}
