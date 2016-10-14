package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_CLASS_GROUPS", inheritanceType = "JOINED", table = "CLASS_GROUPS")
public class ClassGroup extends Entity {

    /**
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID")
    private Company company;

    /**
     */
    @Enumerated
    private Status status;
}
