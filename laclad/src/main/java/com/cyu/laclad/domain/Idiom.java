package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_IDIOMS", identifierColumn = "ID", inheritanceType = "JOINED", table = "IDIOMS")
public class Idiom extends Entity {

    /**
     * Idiom Name
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     */
    @Enumerated
    private Status status;
}
