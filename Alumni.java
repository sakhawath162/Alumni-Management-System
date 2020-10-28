package net.javaguides.springboot.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="alumnies",uniqueConstraints = @UniqueConstraint(columnNames ="email"))
public class Alumni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="NSU_ID")
	@NotBlank
	private String nsuID;
	@NotBlank
	@Column(name="First_Name")
	private String firstName;
	@NotBlank
	@Column(name="Last_Name")
	private String lastName;
	@Email
	private String email;
	@NotBlank
	@Column(name="Major")
	private String major;

	
	
	public String getNsuID() {
		return nsuID;
	}
	public void setNsuID(String nsuID) {
		this.nsuID = nsuID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
