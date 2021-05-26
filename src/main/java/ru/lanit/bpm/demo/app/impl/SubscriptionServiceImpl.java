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

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.repo.PageRepository;
import ru.lanit.bpm.demo.app.repo.SubscriptionRepository;
import ru.lanit.bpm.demo.app.repo.SubscriptionService;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.Subscription;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

/**
 * todo Document type SubscriptionServiceImpl
 */
@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;
    private final PageRepository pageRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Subscription> findSubscriptionByUser(String userLogin) {
        return subscriptionRepository.findByUserLogin(userLogin);
    }

    @Override
    @Transactional
    public void addSubscirption(String userLogin, Long pageId) throws EntityDoesnotExistException {
        User user = userService.findUserByLogin(userLogin);
         pageRepository.findById(pageId).orElseThrow(new EntityDoesnotExistException("not found"));
        subscriptionRepository.save(new Subscription("1", userLogin,pageId));
        Subscription subscription =
        subscriptionRepository.save(subscription);
    }
}
