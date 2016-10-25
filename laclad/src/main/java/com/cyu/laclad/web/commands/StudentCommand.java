package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.domain.ClassGroup;
import com.cyu.laclad.domain.Student;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.Utils;

public class StudentCommand extends PersonCommand {

	private ClassGroup classGroup;
	
    public StudentCommand() {
		super();
	}

    public StudentCommand(Student student) {    	
		super();
		this.id = student.getId();
		this.name = student.getName();
		this.lastName = student.getLastName();
		this.secondLastName = student.getSecondLastName();
		this.birthday = student.getBirthday();
		this.status = student.getStatus();
		this.classGroup = student.getClassGroup(); 
	}

    public Student initStudent() {
    	Student student = new Student();
    	
    	student.setId(this.id);
    	student.setPersonalId(this.personalId);
    	student.setName(this.name);
    	student.setStatus(this.status);
    	
    	student.setLastName(this.lastName);
    	student.setSecondLastName(this.secondLastName);
    	student.setGender(this.gender);
    	student.setBirthday(this.birthday);
    	
    	student.setSystemUser(new SystemUser(this.userName, Utils.generateRandomPassword(), UserType.ROLE_TEACHER, this.status));
    	student.setEnroldDate(new Date());
    	student.setClassGroup(this.classGroup);
    	student.setVersion(this.Version);
    	
    	return student;
    }

	public ClassGroup getClassGroup() {
		return classGroup;
	}

	public void setClassGroup(ClassGroup classGroup) {
		this.classGroup = classGroup;
	}
}