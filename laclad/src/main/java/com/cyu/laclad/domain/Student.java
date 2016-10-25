package com.cyu.laclad.domain;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;
import com.cyu.laclad.web.commands.StudentCommand;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_STUDENTS", inheritanceType = "JOINED", table = "STUDENTS")
public class Student extends PhysicalPerson {

    /**
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private SystemUser systemUser;

    /**
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_GROUP", referencedColumnName = "ID")
    private ClassGroup classGroup;

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
    
    public void updateStudent(StudentCommand student) {
    	this.setPersonalId(student.getPersonalId());
		this.setName(student.getName());
		this.setLastName(student.getLastName());
		this.setSecondLastName(student.getSecondLastName());
		this.setBirthday(student.getBirthday());
		this.setStatus(student.getStatus());
		this.setGender(student.getGender());
		this.setClassGroup(student.getClassGroup());
    }
}
