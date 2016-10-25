package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.Utils;

public class TeacherCommand extends PersonCommand {

	private Idiom mainLanguage;
	
    public TeacherCommand() {
		super();
	}

    public TeacherCommand(Teacher teacher) {    	
		super();
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.lastName = teacher.getLastName();
		this.secondLastName = teacher.getSecondLastName();
		this.birthday = teacher.getBirthday();
		this.status = teacher.getStatus();
		this.mainLanguage = teacher.getMainLanguage(); 
	}

    public Teacher initTeacher() {
    	Teacher teacher = new Teacher();
    	
    	teacher.setId(this.id);
    	teacher.setPersonalId(this.personalId);
    	teacher.setName(this.name);
    	teacher.setStatus(this.status);
    	
    	teacher.setLastName(this.lastName);
    	teacher.setSecondLastName(this.secondLastName);
    	teacher.setGender(this.gender);
    	teacher.setBirthday(this.birthday);
    	
    	teacher.setSystemUser(new SystemUser(this.userName, Utils.generateRandomPassword(), UserType.ROLE_TEACHER, this.status));
    	teacher.setEnroldDate(new Date());
    	teacher.setMainLanguage(this.mainLanguage);
    	teacher.setVersion(this.Version);
    	
    	return teacher;
    }

	public Idiom getMainLanguage() {
		return mainLanguage;
	}

	public void setMainLanguage(Idiom mainLanguage) {
		this.mainLanguage = mainLanguage;
	}
}