package by.gabinet.polski.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Александр Горшов on 11.07.2017  13:37.
 */
@Entity
@Table(name = "SCHEDULE")
@Data
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULE_ID", nullable = false, unique = true)
    private Long id;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COURSE")
    private Date timeStartCourse;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COURSE")
    private Date dateOfCourse;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "schedule")
    private Group group;

    public Schedule() {
    }

    @Builder
    public Schedule(Date timeStartCourse, Date dateOfCourse, Group group) {
        this.timeStartCourse = timeStartCourse;
        this.dateOfCourse = dateOfCourse;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Schedule schedule = (Schedule) o;

        if (id != null ? !id.equals(schedule.id) : schedule.id != null) return false;
        if (timeStartCourse != null ? !timeStartCourse.equals(schedule.timeStartCourse) : schedule.timeStartCourse != null)
            return false;
        return dateOfCourse != null ? dateOfCourse.equals(schedule.dateOfCourse) : schedule.dateOfCourse == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (timeStartCourse != null ? timeStartCourse.hashCode() : 0);
        result = 31 * result + (dateOfCourse != null ? dateOfCourse.hashCode() : 0);
        return result;
    }
}
