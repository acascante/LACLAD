// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.SystemUser;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

privileged aspect SystemUser_Roo_Jpa_Entity {
    
    declare @type: SystemUser: @Entity;
    
    declare @type: SystemUser: @Table(name = "SYSTEM_USERS");
    
    declare @type: SystemUser: @Inheritance(strategy = InheritanceType.JOINED);
    
}
