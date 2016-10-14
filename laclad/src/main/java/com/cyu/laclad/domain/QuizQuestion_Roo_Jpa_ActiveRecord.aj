// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.QuizQuestion;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect QuizQuestion_Roo_Jpa_ActiveRecord {
    
    public static final List<String> QuizQuestion.fieldNames4OrderClauseFilter = java.util.Arrays.asList("idQuiz", "questionNumber", "statement");
    
    public static long QuizQuestion.countQuizQuestions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM QuizQuestion o", Long.class).getSingleResult();
    }
    
    public static List<QuizQuestion> QuizQuestion.findAllQuizQuestions() {
        return entityManager().createQuery("SELECT o FROM QuizQuestion o", QuizQuestion.class).getResultList();
    }
    
    public static List<QuizQuestion> QuizQuestion.findAllQuizQuestions(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizQuestion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizQuestion.class).getResultList();
    }
    
    public static QuizQuestion QuizQuestion.findQuizQuestion(Long id) {
        if (id == null) return null;
        return entityManager().find(QuizQuestion.class, id);
    }
    
    public static List<QuizQuestion> QuizQuestion.findQuizQuestionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM QuizQuestion o", QuizQuestion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<QuizQuestion> QuizQuestion.findQuizQuestionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizQuestion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizQuestion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public QuizQuestion QuizQuestion.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        QuizQuestion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
