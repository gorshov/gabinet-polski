package by.gabinet.polski.service;

/**
 * Created by Александр Горшов on 11.08.2017  18:27.
 */
public interface AnswerServiceInterface<T> extends BaseServiceInterface<T> {
    void deleteById(Long id);
}
