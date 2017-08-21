package by.gabinet.polski.entity;

import by.gabinet.polski.entity.enumiration.Courses;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр Горшов on 18.08.2017  19:30.
 */
@Data
@ToString(exclude = "groupList")
@Table(name = "COURSE")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "COURSE_NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private Courses courseName;

    @Column(name = "DURATION")
    private String duration;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "DESCRIPTION", length = 3000)
    private String description;

  /*  @OneToOne(mappedBy = "course", fetch = FetchType.EAGER)
    private Group group;*/
  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
  @Cascade(CascadeType.SAVE_UPDATE)
  private List<Group> groupList = new ArrayList<>();

    public Course() {
    }

    @Builder
    public Course(Courses courseName, String duration, Double cost, String description, List<Group> groupList) {
        this.courseName = courseName;
        this.duration = duration;
        this.cost = cost;
        this.description = description;
        this.groupList = groupList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        if (duration != null ? !duration.equals(course.duration) : course.duration != null) return false;
        if (cost != null ? !cost.equals(course.cost) : course.cost != null) return false;
        return description != null ? description.equals(course.description) : course.description == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
