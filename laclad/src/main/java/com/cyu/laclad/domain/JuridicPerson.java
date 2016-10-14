package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_JURIDIC_PERSONS", inheritanceType = "TABLE_PER_CLASS", table = "JURIDIC_PERSONS")
public abstract class JuridicPerson extends Person {

    /**
     */
    @Column(name = "JURIDIC_NAME")
    private String juridicName;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    private Representant legalRepresentant;
}
