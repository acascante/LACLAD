// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Representant;
import com.cyu.laclad.enums.Status;
import java.util.Date;

privileged aspect Representant_Roo_JavaBean {
    
    public Date Representant.getEnroldDate() {
        return this.enroldDate;
    }
    
    public void Representant.setEnroldDate(Date enroldDate) {
        this.enroldDate = enroldDate;
    }
    
    public Status Representant.getStatus() {
        return this.status;
    }
    
    public void Representant.setStatus(Status status) {
        this.status = status;
    }
    
}