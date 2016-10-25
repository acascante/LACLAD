package com.cyu.laclad.domain;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;
import com.cyu.laclad.web.commands.TeacherCommand;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_TEACHERS", inheritanceType = "JOINED", table = "TEACHERS")
public class Teacher extends PhysicalPerson {

    /**
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_LANGUAGE", referencedColumnName = "ID")
    private Idiom mainLanguage;

    /**
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private SystemUser systemUser;

    /**
     */
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;

    /**
     */
    @Enumerated
    private Status status;
    
    public void updateTeacher(TeacherCommand teacher) {
    	this.setPersonalId(teacher.getPersonalId());
		this.setName(teacher.getName());
		this.setLastName(teacher.getLastName());
		this.setSecondLastName(teacher.getSecondLastName());
		this.setBirthday(teacher.getBirthday());
		this.setStatus(teacher.getStatus());
		this.setGender(teacher.getGender());
		this.setMainLanguage(teacher.getMainLanguage());
    }
    
    @Override
	public boolean equals(Object obj) {
    	TeacherCommand teacherCommand = (TeacherCommand) obj;
    	if (this.getPersonalId().equals(teacherCommand.getPersonalId()) &&
			this.getName().equals(teacherCommand.getName()) &&
			this.getLastName().equals(teacherCommand.getLastName()) &&
			this.getSecondLastName().equals(teacherCommand.getSecondLastName()) &&
			this.getStatus().equals(teacherCommand.getStatus()) &&
			this.getGender().equals(teacherCommand.getGender()) &&
			this.getMainLanguage().equals(teacherCommand.getMainLanguage()) &&
			this.getBirthday().equals(teacherCommand.getBirthday())) {
				return true;
			}
		return false;
	}
}
