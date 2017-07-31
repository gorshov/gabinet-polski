package by.gabinet.polski.entity.test;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Александр Горшов on 26.07.2017  10:49.
 */
@Table(name = "ANSWER")
@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "ANSWER_FOR_QUESTION")
    private String answerForQuestion;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @Column(name = "STATUS_ANSWER", nullable = false)
    private Boolean statusAnswer;

    public Answer() {
        
    }

    @Builder
    public Answer(String answerForQuestion, Question question, Boolean statusAnswer) {
        this.answerForQuestion = answerForQuestion;
        this.question = question;
        this.statusAnswer = statusAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Answer answer = (Answer) o;

        if (id != null ? !id.equals(answer.id) : answer.id != null) return false;
        if (answerForQuestion != null ? !answerForQuestion.equals(answer.answerForQuestion) : answer.answerForQuestion != null)
            return false;
        return statusAnswer != null ? statusAnswer.equals(answer.statusAnswer) : answer.statusAnswer == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (answerForQuestion != null ? answerForQuestion.hashCode() : 0);
        result = 31 * result + (statusAnswer != null ? statusAnswer.hashCode() : 0);
        return result;
    }
}
