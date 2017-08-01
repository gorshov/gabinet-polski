package by.gabinet.polski.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр Горшов on 25.07.2017  16:51.
 */
@ToString(exclude = "groupList")
@Table(name = "TEACHER")
@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "LANGUAGE")
    private String language;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    private List<Group> groupList = new ArrayList<Group>();


    public Teacher() {

    }

    @Builder
    public Teacher(String firstName, String lastName, String email, String password, String confirmPassword, String language, List<Group> groupList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.language = language;
        this.groupList = groupList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (id != null ? !id.equals(teacher.id) : teacher.id != null) return false;
        if (firstName != null ? !firstName.equals(teacher.firstName) : teacher.firstName != null) return false;
        if (lastName != null ? !lastName.equals(teacher.lastName) : teacher.lastName != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (password != null ? !password.equals(teacher.password) : teacher.password != null) return false;
        if (confirmPassword != null ? !confirmPassword.equals(teacher.confirmPassword) : teacher.confirmPassword != null)
            return false;
        return language != null ? language.equals(teacher.language) : teacher.language == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
