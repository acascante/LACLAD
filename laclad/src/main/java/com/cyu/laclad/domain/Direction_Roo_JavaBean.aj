// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.Location;
import com.cyu.laclad.enums.DirectionType;

privileged aspect Direction_Roo_JavaBean {
    
    public String Direction.getStreet() {
        return this.street;
    }
    
    public void Direction.setStreet(String street) {
        this.street = street;
    }
    
    public String Direction.getOtherSigns() {
        return this.otherSigns;
    }
    
    public void Direction.setOtherSigns(String otherSigns) {
        this.otherSigns = otherSigns;
    }
    
    public String Direction.getZipCode() {
        return this.zipCode;
    }
    
    public void Direction.setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public Location Direction.getLocation() {
        return this.location;
    }
    
    public void Direction.setLocation(Location location) {
        this.location = location;
    }
    
    public DirectionType Direction.getType() {
        return this.type;
    }
    
    public void Direction.setType(DirectionType type) {
        this.type = type;
    }
    
}