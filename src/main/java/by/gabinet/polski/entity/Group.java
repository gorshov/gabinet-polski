package by.gabinet.polski.entity;

import by.gabinet.polski.entity.enumiration.Courses;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Column(name = "COURSE_NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private Courses courseName;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<User> userList = new ArrayList<User>();

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @Column(name = "COST")
    private Double cost;

    public Group() {

    }

    @Builder
    public Group(Courses courseName, Boolean status, Schedule schedule, List<User> userList, Teacher teacher, Double cost) {
        this.courseName = courseName;
        this.status = status;
        this.schedule = schedule;
        this.userList = userList;
        this.teacher = teacher;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (courseName != group.courseName) return false;
        if (status != null ? !status.equals(group.status) : group.status != null) return false;
        return cost != null ? cost.equals(group.cost) : group.cost == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
