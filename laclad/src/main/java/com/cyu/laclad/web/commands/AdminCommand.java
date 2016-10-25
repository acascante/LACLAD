package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.domain.Admin;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.Utils;

public class AdminCommand extends PersonCommand {

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
}