package com.example.homework2.service.concretes;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homework2.core.utilities.results.DataResult;
import com.example.homework2.core.utilities.results.ErrorResult;
import com.example.homework2.core.utilities.results.Result;
import com.example.homework2.core.utilities.results.SuccessDataResult;
import com.example.homework2.core.utilities.results.SuccessResult;
import com.example.homework2.dataAccess.abstracts.PersonnelDao;
import com.example.homework2.model.Personnel;
import com.example.homework2.service.abstracts.PersonnelService;

@Service
public class PersonnelManager implements PersonnelService {

	 private PersonnelDao personnelDao;
	 
	 @Autowired
	 public PersonnelManager(PersonnelDao personnelDao) {
		
		 this.personnelDao=personnelDao;
	 }
	
	
	@Override
	public DataResult<List<Personnel>> getAll() {
		
		return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll(),"personeller listelendi");
	}

	@Override
	public Result add(Personnel personnel) {
		
		if(personnel.getName().isEmpty() == true) {
			return new ErrorResult("isim alanı bos birakilamaz");
			
		}else if(personnel.getSurname().isEmpty() ==true) {
			return new ErrorResult("soyisim alanı bos birakilamaz");
			
		}else if( personnel.getSex().isEmpty()==true) {
			return new ErrorResult("cinsiyet alanı bos birakilamaz");
		}
		else {
		this.personnelDao.save(personnel);
			return new SuccessResult("Personel eklendi");
		
		}	
	}

	@Override
	public Result delete(Personnel personnel) {
		
	     this.personnelDao.deleteById(personnel.getId());
		return new SuccessResult("personel silindi");
	}

	@Override
	public Result update(Personnel personnel) {
		Optional<Personnel> getPersonnel = personnelDao.findById(personnel.getId());
		  if(!getPersonnel.isPresent()) {
			  return new ErrorResult("personel bulunamadı");
		  }
		  this.personnelDao.save(personnel);
		return new SuccessResult("personel bilgisi güncellendi");
	}

}
