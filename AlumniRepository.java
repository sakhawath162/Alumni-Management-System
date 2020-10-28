package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Alumni;


@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {
	Alumni findByEmail(String email);

}
