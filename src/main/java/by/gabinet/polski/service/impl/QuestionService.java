package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.QuestionDaoInterface;
import by.gabinet.polski.entity.test.Question;
import by.gabinet.polski.service.QuestionServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Александр Горшов on 14.08.2017  16:34.
 */
@Service
@Transactional
public class QuestionService extends BaseService<Question> implements QuestionServiceInterface<Question> {
    private static Logger log = Logger.getLogger(QuestionService.class);

    @Autowired
    @Qualifier("questionDao")
    private QuestionDaoInterface questionDaoInterface;

    @Override
    public void deleteById(Long id) {
        log.info("start service method deleteById with id " + id);
        questionDaoInterface.deleteById(id);
    }
}
