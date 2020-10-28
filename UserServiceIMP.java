package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Alumni;
import net.javaguides.springboot.repository.AlumniRepository;

@Service
public class UserServiceIMP implements UserService{
	
	@Autowired
	AlumniRepository ar;

	@Override
	public void saveAlumni(Alumni alumni) {
		 ar.save(alumni);
	}

	@Override
	public Alumni findByEmail(String email) {
		return ar.findByEmail(email);
	}

	@Override
	public List<Alumni> getAllAlumni() {
		return ar.findAll();
	}

	@Override
	public Alumni getAlumniById(long id) {
		Optional<Alumni> optional = ar.findById(id);
		Alumni alumni = null;
		if(optional.isPresent()) {
			alumni = optional.get();
		}else {
			throw new RuntimeException("No Alumni Found");
		}
		
		return alumni;
	}

	@Override
	public void deleteAlumni(Alumni alumni) {
		ar.delete(alumni);
		
	}


}
