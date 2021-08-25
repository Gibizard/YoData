package ru.lanit.bpm.demo.adapter.hibernate;

import ru.lanit.bpm.demo.domain.User;

import java.util.Map;
import java.util.Optional;

public interface UserRepositoryCustom {
    Map<String, User> custom();

    Optional<User> findByTelegramId(String telegramId);
}