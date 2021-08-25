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
import ru.lanit.bpm.demo.app.repo.SubscriptionRepository;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Transactional(readOnly = true)
    @Override
    public User findUserByLogin(String userLogin) throws EntityDoesnotExistException {
        return userRepository.findById(userLogin).orElseThrow(() -> new EntityDoesnotExistException("User: " + userLogin+ " not found"));
    }

    @Transactional
    @Override
    public Optional<User> getUserByTelegramId(String telegramId) {
        return userRepository.findByTelegramId(telegramId);
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
}
