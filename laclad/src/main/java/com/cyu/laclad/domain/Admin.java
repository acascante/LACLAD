package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.web.commands.AdminCommand;

import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_ADMINS", inheritanceType = "JOINED", table = "ADMINS")
public class Admin extends PhysicalPerson {

    /**
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private SystemUser systemUser;

    /**
     */
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date enroldDate;

    /**
     */
    @Enumerated
    private Status status;
    
    public void updateAdmin(AdminCommand admin) {
    	this.setPersonalId(admin.getPersonalId());
		this.setName(getName());
		this.setLastName(admin.getLastName());
		this.setSecondLastName(admin.getSecondLastName());
		this.setBirthday(admin.getBirthday());
		this.setStatus(admin.getStatus());
    }
    
    @Override
	public boolean equals(Object obj) {
    	AdminCommand adminCommand = (AdminCommand) obj;
    	if (this.getPersonalId().equals(adminCommand.getPersonalId()) &&
			this.getName().equals(adminCommand.getName()) &&
			this.getLastName().equals(adminCommand.getLastName()) &&
			this.getSecondLastName().equals(adminCommand.getSecondLastName()) &&
			this.getStatus().equals(adminCommand.getStatus()) &&
			this.getBirthday().equals(adminCommand.getBirthday())) {
				return true;
			}
		return false;
	}
}
