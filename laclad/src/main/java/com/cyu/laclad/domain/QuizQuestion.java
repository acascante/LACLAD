package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZZES_QUESTIONS", inheritanceType = "JOINED", table = "QUIZZES_QUESTIONS")
public class QuizQuestion extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ", referencedColumnName = "ID")
    private Quiz idQuiz;

    /**
     */
    @NotNull
    @Column(name = "QUESTION_NUMBER")
    private Integer questionNumber;

    /**
     */
    @NotNull
    @Column(name = "STATEMENT")
    private String statement;
}
