// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.PhysicalPerson;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PhysicalPerson_Roo_Jpa_ActiveRecord {
    
    public static final List<String> PhysicalPerson.fieldNames4OrderClauseFilter = java.util.Arrays.asList("lastName", "secondLastName", "gender", "birthday");
    
    public static long PhysicalPerson.countPhysicalpeople() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PhysicalPerson o", Long.class).getSingleResult();
    }
    
    public static List<PhysicalPerson> PhysicalPerson.findAllPhysicalpeople() {
        return entityManager().createQuery("SELECT o FROM PhysicalPerson o", PhysicalPerson.class).getResultList();
    }
    
    public static List<PhysicalPerson> PhysicalPerson.findAllPhysicalpeople(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PhysicalPerson o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PhysicalPerson.class).getResultList();
    }
    
    public static PhysicalPerson PhysicalPerson.findPhysicalPerson(Long id) {
        if (id == null) return null;
        return entityManager().find(PhysicalPerson.class, id);
    }
    
    public static List<PhysicalPerson> PhysicalPerson.findPhysicalPersonEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PhysicalPerson o", PhysicalPerson.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<PhysicalPerson> PhysicalPerson.findPhysicalPersonEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM PhysicalPerson o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, PhysicalPerson.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public PhysicalPerson PhysicalPerson.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PhysicalPerson merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
