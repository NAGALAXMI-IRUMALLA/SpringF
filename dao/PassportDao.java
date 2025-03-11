package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.repo.PassportRepo;
@Repository
public class PassportDao {
	@Autowired
	PassportRepo passportRepo;
	
	public Passport savePassport(Passport passport) {
		return passportRepo.save(passport);
	}
	public Passport fetchPassportById(int passportId) {
		Optional<Passport> passport=passportRepo.findById(passportId);
		if(passport.isPresent()) {
			return passport.get();
		}
		return null;
	}
	public Passport updatePassportById(int oldPassportId,Passport newPassport) {
		newPassport.setPassportId(oldPassportId);
		return passportRepo.save(newPassport);
	}
	public Passport deletePassportById(int passportId) {
		Passport passport=fetchPassportById(passportId);
		passportRepo.delete(passport);
		return passport;
	}
	public List<Passport> fetchAllPassport(){
		return passportRepo.findAll();
	}
	
	

}
