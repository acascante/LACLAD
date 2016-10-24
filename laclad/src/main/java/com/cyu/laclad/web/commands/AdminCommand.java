package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.domain.Admin;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.Utils;

public class AdminCommand {

	private Long id;
    private Long personalId;
    private String name;
    private String lastName;
    private String secondLastName;
    private String userName;
    private String password;
    private String repeatPassword;
    private Date enroldDate;
    private String birthday;
    private Status status;
    private UserType type;
    private Gender gender;
    private Integer Version;
    
    public AdminCommand() {
		super();
	}

    public AdminCommand(Admin admin) {    	
		super();
		this.id = admin.getId();
		this.personalId = admin.getPersonalId();
		this.name = admin.getName();
		this.lastName = admin.getLastName();
		this.secondLastName = admin.getSecondLastName();
		this.birthday = admin.getBirthday();
		this.status = admin.getStatus();
	}

    public Admin initAdmin() {
    	Admin admin = new Admin();
    	
    	admin.setId(this.id);
    	admin.setPersonalId(this.personalId);
    	admin.setName(this.name);
    	admin.setStatus(this.status);
    	
    	admin.setLastName(this.lastName);
    	admin.setSecondLastName(this.secondLastName);
    	admin.setGender(this.gender);
    	admin.setBirthday(this.birthday);
    	
    	admin.setSystemUser(new SystemUser(this.userName, Utils.generateRandomPassword(), UserType.ROLE_ADMIN, this.status));
    	admin.setEnroldDate(new Date());
    	admin.setVersion(this.Version);
    	
    	return admin;
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
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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