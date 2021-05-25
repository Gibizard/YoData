package ru.lanit.bpm.demo.adapter.hibernate;

import ru.lanit.bpm.demo.app.repo.UserRepositoryCustom;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Map;

@Component
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Autowired
    EntityManager entityManager;
    @Override
    public Map<String, User> custom() {
        return null;
    }
}
