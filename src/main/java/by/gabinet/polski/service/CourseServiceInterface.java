package by.gabinet.polski.service;

/**
 * Created by Александр Горшов on 20.08.2017  23:02.
 */
public interface CourseServiceInterface<T> extends BaseServiceInterface<T> {

    void deleteById(Long id);
}
