package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;

public class PersonCommand {

	protected Long id;
	protected Long personalId;
	protected String name;
	protected String lastName;
	protected String secondLastName;
	protected String userName;
	protected String password;
    protected Date enroldDate;
    protected String birthday;
    protected Status status;
    protected UserType type;
    protected Gender gender;
    protected Integer Version;
    
    public PersonCommand() {
		super();
	}

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPersonalId() {
		return personalId;
	}
	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getEnroldDate() {
		return enroldDate;
	}
	public void setEnroldDate(Date enroldDate) {
		this.enroldDate = enroldDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Integer getVersion() {
		return Version;
	}
	public void setVersion(Integer version) {
		Version = version;
	}
}