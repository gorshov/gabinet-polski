package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.AnswerDaoInterface;
import by.gabinet.polski.entity.test.Answer;
import by.gabinet.polski.service.AnswerServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Александр Горшов on 14.08.2017  20:04.
 */
public class AnswerService extends BaseService<Answer> implements AnswerServiceInterface<Answer> {
    private static Logger log = Logger.getLogger(AnswerService.class);

    @Autowired
    @Qualifier("answerDao")
    private AnswerDaoInterface answerDaoInterface;

    @Override
    public void deleteById(Long id) {
        log.info("start service method deleteById with id " + id);
        answerDaoInterface.deleteById(id);
    }
}
