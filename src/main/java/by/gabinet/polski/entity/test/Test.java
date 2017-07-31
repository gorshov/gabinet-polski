package by.gabinet.polski.entity.test;

import by.gabinet.polski.entity.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Александр Горшов on 26.07.2017  10:48.
 */
@Table(name = "TEST")
@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "TEST_NAME")
    private String testName;

    @Column(name = "EMAIL_REQUEST", nullable = false)
    private String emailRequest;

    //private User user; //if need save result after test for user
    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY)
    @Cascade({CascadeType.REMOVE, CascadeType.SAVE_UPDATE})
    private Set<Question> questionSet = new HashSet<Question>();

    public Test() {

    }

    @Builder
    public Test(String testName, String emailRequest, Set<Question> questionSet) {
        this.testName = testName;
        this.emailRequest = emailRequest;
        this.questionSet = questionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Test test = (Test) o;

        if (id != null ? !id.equals(test.id) : test.id != null) return false;
        if (testName != null ? !testName.equals(test.testName) : test.testName != null) return false;
        return emailRequest != null ? emailRequest.equals(test.emailRequest) : test.emailRequest == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (testName != null ? testName.hashCode() : 0);
        result = 31 * result + (emailRequest != null ? emailRequest.hashCode() : 0);
        return result;
    }
}
