package by.gabinet.polski.entity.enumiration;

/**
 * Created by Александр Горшов on 11.07.2017  14:59.
 */
public enum Courses {
    MAP_POLES("Курс \"Карта Поляка\""), FROM_ZERO_TO_A2("Курс \"С нуля до A2\""), FROM_A1_A2_TO_B2("Курс \"С A1 - A2 до B2\""), FROM_B2_TO_C1("Курс \"B2 - C1\"");

    String courseName;

    Courses(String course) {
        this.courseName = course;
    }

    public String getCourseName() {
        return courseName;
    }

}
