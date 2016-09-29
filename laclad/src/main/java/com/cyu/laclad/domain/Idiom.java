package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_IDIOMS", identifierColumn = "ID", identifierField = "id", table = "IDIOMS")
public class Idiom {

    /**
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
}
