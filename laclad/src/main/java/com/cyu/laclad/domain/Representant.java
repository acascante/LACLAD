package com.cyu.laclad.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_REPRESENTANTS", inheritanceType = "JOINED", table = "REPRESENTANTS")
public class Representant extends PhysicalPerson {

    /**
     */
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;

	public Representant() {
		super();
	}
	
	public Representant(Long personalId, String name, Status status, String lastName, String secondLastName, String birthday, Gender gender, Date enroldDate) {
		super(personalId, name, status, lastName, secondLastName, birthday, gender);
		this.enroldDate = enroldDate;
	}
}