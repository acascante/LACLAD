package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_PHONES", inheritanceType = "JOINED", table = "PHONES")
public class Phone extends Entity {

    /**
     */
    @NotNull
    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;
}
