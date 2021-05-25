package ru.lanit.bpm.demo.app.repo;

import ru.lanit.bpm.demo.domain.User;

import java.util.Map;

public interface UserRepositoryCustom {
    Map<String, User> custom();
}
