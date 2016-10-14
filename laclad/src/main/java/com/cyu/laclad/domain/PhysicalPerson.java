package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.Gender;
import javax.persistence.Enumerated;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_PHYSICAL_PERSONS", inheritanceType = "TABLE_PER_CLASS", table = "PHYSICAL_PERSONS")
public abstract class PhysicalPerson extends Person {

    /**
     */
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     */
    @Column(name = "SECOND_LAST_NAME")
    private String secondLastName;

    /**
     */
    @Enumerated
    private Gender gender;

    /**
     */
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthday;
}
