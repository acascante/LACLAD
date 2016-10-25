// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.PhysicalPerson;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect PhysicalPerson_Roo_Finder {
    
    public static Long PhysicalPerson.countFindPhysicalpeopleByPersonalIdEquals(Long personalId) {
        if (personalId == null) throw new IllegalArgumentException("The personalId argument is required");
        EntityManager em = PhysicalPerson.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM PhysicalPerson AS o WHERE o.personalId = :personalId", Long.class);
        q.setParameter("personalId", personalId);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<PhysicalPerson> PhysicalPerson.findPhysicalpeopleByPersonalIdEquals(Long personalId) {
        if (personalId == null) throw new IllegalArgumentException("The personalId argument is required");
        EntityManager em = PhysicalPerson.entityManager();
        TypedQuery<PhysicalPerson> q = em.createQuery("SELECT o FROM PhysicalPerson AS o WHERE o.personalId = :personalId", PhysicalPerson.class);
        q.setParameter("personalId", personalId);
        return q;
    }
    
    public static TypedQuery<PhysicalPerson> PhysicalPerson.findPhysicalpeopleByPersonalIdEquals(Long personalId, String sortFieldName, String sortOrder) {
        if (personalId == null) throw new IllegalArgumentException("The personalId argument is required");
        EntityManager em = PhysicalPerson.entityManager();
        StringBuilder queryBuilder = new StringBuilder("SELECT o FROM PhysicalPerson AS o WHERE o.personalId = :personalId");
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            queryBuilder.append(" ORDER BY ").append(sortFieldName);
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                queryBuilder.append(" ").append(sortOrder);
            }
        }
        TypedQuery<PhysicalPerson> q = em.createQuery(queryBuilder.toString(), PhysicalPerson.class);
        q.setParameter("personalId", personalId);
        return q;
    }
    
}