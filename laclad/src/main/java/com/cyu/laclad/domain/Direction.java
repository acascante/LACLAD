package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.cyu.laclad.enums.DirectionType;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_DIRECTIONS", inheritanceType = "JOINED", table = "DIRECTIONS")
public class Direction extends Entity {

    /**
     */
    @NotNull
    @Column(name = "STREET")
    private String street;

    /**
     */
    @NotNull
    @Column(name = "OTRER_SIGNS")
    private String otherSigns;

    /**
     */
    @NotNull
    @Column(name = "ZIP_CODE")
    private String zipCode;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_LOCATION", referencedColumnName = "ID")
    private Location location;

    /**
     */
    @Enumerated
    private DirectionType type;
}
