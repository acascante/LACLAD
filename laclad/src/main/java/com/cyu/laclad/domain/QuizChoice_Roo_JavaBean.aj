// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.QuizChoice;
import com.cyu.laclad.domain.QuizQuestion;

privileged aspect QuizChoice_Roo_JavaBean {
    
    public QuizQuestion QuizChoice.getIdQuestion() {
        return this.idQuestion;
    }
    
    public void QuizChoice.setIdQuestion(QuizQuestion idQuestion) {
        this.idQuestion = idQuestion;
    }
    
    public Integer QuizChoice.getOptionNumber() {
        return this.optionNumber;
    }
    
    public void QuizChoice.setOptionNumber(Integer optionNumber) {
        this.optionNumber = optionNumber;
    }
    
    public String QuizChoice.getDescription() {
        return this.description;
    }
    
    public void QuizChoice.setDescription(String description) {
        this.description = description;
    }
    
    public Boolean QuizChoice.getIsTrue() {
        return this.isTrue;
    }
    
    public void QuizChoice.setIsTrue(Boolean isTrue) {
        this.isTrue = isTrue;
    }
    
}
