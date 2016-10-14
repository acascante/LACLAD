package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "JOINED", table = "PERSONS")
public abstract class Person extends Entity {

    /**
     * Personal ID
     */
    @NotNull
    @Column(name = "PERSONAL_ID", unique = true)
    private Long personalId;

    /**
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     */
    @Enumerated
    private Status status;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Direction> directions = new HashSet<Direction>();

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Email> emails = new HashSet<Email>();

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Phone> phones = new HashSet<Phone>();
}
