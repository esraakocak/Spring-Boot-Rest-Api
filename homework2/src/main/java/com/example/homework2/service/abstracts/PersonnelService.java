package com.example.homework2.service.abstracts;

import java.util.List;

import com.example.homework2.core.utilities.results.DataResult;
import com.example.homework2.core.utilities.results.Result;
import com.example.homework2.model.Personnel;

public interface PersonnelService {
	
	DataResult<List<Personnel>> getAll();
	Result add(Personnel personnel);
	Result delete(Personnel personnel);
	Result update(Personnel personnel);
	
}
