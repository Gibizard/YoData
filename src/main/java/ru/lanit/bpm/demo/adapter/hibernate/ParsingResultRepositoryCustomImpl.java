package ru.lanit.bpm.demo.adapter.hibernate;

import lombok.RequiredArgsConstructor;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ParsingResultRepositoryCustomImpl implements ParsingResultRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public Map<ParsingResult, List<User>> fetchUnsentResult() {
        List<ParsingResult> prList = entityManager.createQuery("select pr from ParsingResult pr where pr.sent = false", ParsingResult.class).getResultList();
        Map<ParsingResult, List<User>> result = new HashMap<>();
        for (ParsingResult pr : prList) {
            Long pageId = pr.getPage().getId();
            List<User> uList =
                    entityManager.createQuery("select u from User u join Subscription s on u.login = s.user join s.page p where p.id =" + pageId, User.class)
                            .getResultList();
            result.put(pr, uList);
        }
        return result;
    }
}