// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.PhysicalPerson;
import com.cyu.laclad.enums.Gender;

privileged aspect PhysicalPerson_Roo_JavaBean {
    
    public String PhysicalPerson.getLastName() {
        return this.lastName;
    }
    
    public void PhysicalPerson.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String PhysicalPerson.getSecondLastName() {
        return this.secondLastName;
    }
    
    public void PhysicalPerson.setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }
    
    public String PhysicalPerson.getBirthday() {
        return this.birthday;
    }
    
    public void PhysicalPerson.setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public Gender PhysicalPerson.getGender() {
        return this.gender;
    }
    
    public void PhysicalPerson.setGender(Gender gender) {
        this.gender = gender;
    }
    
}
