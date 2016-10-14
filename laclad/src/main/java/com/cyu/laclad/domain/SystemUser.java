package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.UserType;
import javax.persistence.Enumerated;
import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_SYSTEM_USERS", inheritanceType = "JOINED", table = "SYSTEM_USERS")
public class SystemUser extends Entity {

    /**
     */
    @NotNull
    @Column(name = "USER_NAME")
    private String userName;

    /**
     */
    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    /**
     */
    @Enumerated
    private UserType type;

    /**
     */
    @Enumerated
    private Status status;
}
