// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Student;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

privileged aspect Student_Roo_Jpa_Entity {
    
    declare @type: Student: @Entity;
    
    declare @type: Student: @Table(name = "STUDENTS");
    
    declare @type: Student: @Inheritance(strategy = InheritanceType.JOINED);
    
}
