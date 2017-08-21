package by.gabinet.polski.service;

/**
 * Created by Александр Горшов on 11.08.2017  18:10.
 */
public interface QuestionServiceInterface<T> extends BaseServiceInterface<T> {

    void deleteById(Long id);
}
