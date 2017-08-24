package by.gabinet.polski.entity;

import by.gabinet.polski.entity.enumiration.Courses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр Горшов on 11.07.2017  13:37.
 */
@ToString(exclude = "userList")
@Data
@Table(name = "`GROUP`")
@Entity
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "GROUP_DESCRIPTION", length = 5000)
    private String groupDescription;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JsonIgnore
    private List<User> userList = new ArrayList<User>();

    @Column(name = "TIME_COURSE")
    private Time timeStartCourse;

    @Column(name = "DATE_COURSE")
    private Date dateOfCourse;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    @JsonIgnore
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    public Group() {

    }

    @Builder
    public Group(String groupDescription, Boolean status, List<User> userList, Time timeStartCourse, Date dateOfCourse, Teacher teacher, Course course) {
        this.groupDescription = groupDescription;
        this.status = status;
        this.userList = userList;
        this.timeStartCourse = timeStartCourse;
        this.dateOfCourse = dateOfCourse;
        this.teacher = teacher;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (groupDescription != null ? !groupDescription.equals(group.groupDescription) : group.groupDescription != null)
            return false;
        if (status != null ? !status.equals(group.status) : group.status != null) return false;
        if (timeStartCourse != null ? !timeStartCourse.equals(group.timeStartCourse) : group.timeStartCourse != null)
            return false;
        return dateOfCourse != null ? dateOfCourse.equals(group.dateOfCourse) : group.dateOfCourse == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (groupDescription != null ? groupDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (timeStartCourse != null ? timeStartCourse.hashCode() : 0);
        result = 31 * result + (dateOfCourse != null ? dateOfCourse.hashCode() : 0);
        return result;
    }
}
