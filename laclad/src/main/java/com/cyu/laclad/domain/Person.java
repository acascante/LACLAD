package com.cyu.laclad.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "JOINED", table = "PERSONS")
public abstract class Person extends Entity {

    /**
     * Personal ID
     */
    @NotNull
    @Column(name = "PERSONAL_ID")
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
    private Set<Phone> phones = new HashSet<Phone>();

    public Person() {
		super();
	}
    
    public Person(Long personalId, String name, Status status) {
		super();
		this.personalId = personalId;
		this.name = name;
		this.status = status;
	}
    
    public Person(Long personalId, String name, Status status, Set<Direction> directions, Set<Phone> phones) {
		super();
		this.personalId = personalId;
		this.name = name;
		this.status = status;
		this.directions = directions;
		this.phones = phones;
	}
}