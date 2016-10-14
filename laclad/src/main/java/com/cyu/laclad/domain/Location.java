package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_LOCATIONS", inheritanceType = "JOINED", table = "LOCATIONS")
public class Location extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_PARENT_LOCATION", referencedColumnName = "ID")
    private Location idParentLocation;

    /**
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
}
