// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Phone;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Phone_Roo_Jpa_ActiveRecord {
    
    public static final List<String> Phone.fieldNames4OrderClauseFilter = java.util.Arrays.asList("phoneNumber");
    
    public static long Phone.countPhones() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Phone o", Long.class).getSingleResult();
    }
    
    public static List<Phone> Phone.findAllPhones() {
        return entityManager().createQuery("SELECT o FROM Phone o", Phone.class).getResultList();
    }
    
    public static List<Phone> Phone.findAllPhones(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Phone o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Phone.class).getResultList();
    }
    
    public static Phone Phone.findPhone(Long id) {
        if (id == null) return null;
        return entityManager().find(Phone.class, id);
    }
    
    public static List<Phone> Phone.findPhoneEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Phone o", Phone.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Phone> Phone.findPhoneEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Phone o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Phone.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public Phone Phone.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Phone merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}