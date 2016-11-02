package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_COMPANIES", inheritanceType = "JOINED", table = "COMPANIES")
public class Company extends JuridicPerson {

    /**
     */
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date enroldDate;

	public Company(Date enroldDate) {
		super();
		this.enroldDate = enroldDate;
	}

	public Company() {
		super();
	}
}