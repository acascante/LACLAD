// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.QuizChoice;
import com.cyu.laclad.domain.QuizResponse;
import com.cyu.laclad.domain.QuizStudent;
import com.cyu.laclad.enums.Status;

privileged aspect QuizResponse_Roo_JavaBean {
    
    public QuizStudent QuizResponse.getIdQuizStudent() {
        return this.idQuizStudent;
    }
    
    public void QuizResponse.setIdQuizStudent(QuizStudent idQuizStudent) {
        this.idQuizStudent = idQuizStudent;
    }
    
    public QuizChoice QuizResponse.getIdOption() {
        return this.idOption;
    }
    
    public void QuizResponse.setIdOption(QuizChoice idOption) {
        this.idOption = idOption;
    }
    
    public Status QuizResponse.getStatus() {
        return this.status;
    }
    
    public void QuizResponse.setStatus(Status status) {
        this.status = status;
    }
    
}
