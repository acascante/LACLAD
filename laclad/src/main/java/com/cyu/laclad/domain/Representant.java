package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

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

    /**
     */
    @Enumerated
    private Status status;
}
