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
@RooJpaActiveRecord(sequenceName = "SQ_QUIZZES_RESPONSES", inheritanceType = "JOINED", table = "QUIZZES_RESPONSES")
public class QuizResponse extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ_STUDENT", referencedColumnName = "ID")
    private QuizStudent idQuizStudent;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_OPTION", referencedColumnName = "ID")
    private QuizChoice idOption;

    /**
     */
    @Enumerated
    private Status status;
}
