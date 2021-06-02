package ru.lanit.bpm.demo.adapter.hibernate;

import ru.lanit.bpm.demo.app.repo.UserRepositoryCustom;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    EntityManager entityManager;
    @Override
    public Map<String, User> custom() {
        return null;
    }

    @Override
    public Optional<User> findByTelegramId(String telegramId) {
        return findByTelegramId(telegramId);
    }
}
