package net.javaguides.springboot.service;


import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Alumni;

@Service
public interface UserService {
	void saveAlumni(Alumni alumni);
	Alumni findByEmail(String email);
	List<Alumni> getAllAlumni();
	Alumni getAlumniById(long id);
	void deleteAlumni(Alumni alumni);

}
