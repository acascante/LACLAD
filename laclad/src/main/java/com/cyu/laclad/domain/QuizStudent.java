package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZZES_STUDENTS", inheritanceType = "JOINED", table = "QUIZZES_STUDENTS")
public class QuizStudent extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ", referencedColumnName = "ID")
    private Quiz idQuiz;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID")
    private Student idStudent;

    /**
     */
    @Enumerated
    private Status status;
}
