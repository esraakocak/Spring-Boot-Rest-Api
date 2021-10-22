package com.example.homework2.dataAccess.abstracts;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.homework2.model.Personnel;

@Repository
public interface PersonnelDao extends MongoRepository<Personnel,String>{

	

}
