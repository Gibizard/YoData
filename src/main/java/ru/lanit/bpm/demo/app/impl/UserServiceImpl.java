/*
 * Copyright (c) 2008-2021
 * LANIT
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * LANIT and its licensors, if any.
 *
 * $
 */
package ru.lanit.bpm.demo.app.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.app.repo.SubscriptionRepository;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ParsingResultRepository parsingResultRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findUserByLogin(String userLogin) {
        return userRepository.findById(userLogin);
    }

    @Transactional
    @Override
    public Optional<User> getUserByTelegramId(String telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }

    @Override
    public void addUser(User newUser) throws DuplicateEntityException {
        userRepository.save(newUser);
    }

    @Override
    public void addUser(String login, String password, @NonNull String firstName, String lastName, String telegramId) {
        userRepository.save(new User(login, password, firstName, lastName, telegramId));
    }

    @Override
    public void updatePassword(String login, String text) {
        User user = userRepository.findById(login).orElseThrow();
        user.setPassword(text);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteUser(String login) throws EntityDoesnotExistException{
        if (findUserByLogin(login).isPresent()){
            userRepository.deleteById(login);
        } else throw new EntityDoesnotExistException("No user " + login +" to delete");
    }

    @Override
    public boolean checkPasswordByLogin(String login, String password) {
        return userRepository.existsByLoginAndPassword(login, password);
    }

    @Override
    public Map<ParsingResult, List<User>> fetchUnsentResults() {
        return parsingResultRepository.fetchUnsentResult();
    }
}
