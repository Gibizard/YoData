package ru.lanit.bpm.demo.adapter.hibernate;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepositoryCustom;
import ru.lanit.bpm.demo.app.repo.UserRepositoryCustom;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ParsingResultsRepositoryCustomImpl implements ParsingResultRepositoryCustom {
    private final EntityManager entityManager;
    @Override
    public Map<ParsingResult, List<User>> custom() {
        return entityManager.createQuery(
                "select parsingResult.sent, parsingResult.page, parsingResult.result from ParsingResult parsingResult " +
                        "inner join Subscription subscription on (subscription.page = parsingResult.page) " +
                        "inner join User user on (user.login = subscription.user)" +
                "where parsingResult.sent = false ").getResultStream().collect(Collectors.toMap(row -> ((ParsingResult) row.get("")),)
        );
    }
}