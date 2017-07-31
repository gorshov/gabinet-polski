package by.gabinet.polski.entity.test;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Александр Горшов on 26.07.2017  10:48.
 */
@Table(name = "QUESTION")
@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "TEXT_QUESTION", nullable = false, unique = true)
    private String textQuestion;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private List<Answer> answerList = new LinkedList<Answer>();
    //private Map<Answer, Boolean> answerMap = new HashMap<Answer, Boolean>(); if list not worked

    @ManyToOne
    @JoinColumn(name = "TEST_ID")
    private Test test;

    public Question() {

    }

    @Builder
    public Question(String textQuestion, List<Answer> answerList, Test test) {
        this.textQuestion = textQuestion;
        this.answerList = answerList;
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) return false;
        return textQuestion != null ? textQuestion.equals(question.textQuestion) : question.textQuestion == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (textQuestion != null ? textQuestion.hashCode() : 0);
        return result;
    }
}

