package by.gabinet.polski.entity.enumiration;

/**
 * Created by Александр Горшов on 11.07.2017  14:59.
 */
public enum Courses {
    MAP_POLES("MAP_OF_POLES"), BEGINNER("BEGINNER"), ON_LEVEL("ON_LEVEL");

    String course;

    Courses(String course) {
        this.course = course;
    }

    public String getRole() {
        return course;
    }

}
