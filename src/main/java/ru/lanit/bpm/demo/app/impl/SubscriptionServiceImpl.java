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
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.repo.SubscriptionRepository;
import ru.lanit.bpm.demo.app.SubscriptionService;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.Subscription;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * todo Document type SubscriptionServiceImpl
 */
@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;
    private final PageService pageService;

    @Transactional(readOnly = true)
    @Override
    public List<Subscription> findSubscriptionByUser(String userLogin) {
        return subscriptionRepository.findByUserLogin(userLogin);
    }

    @Override
    public Optional<Subscription> findSubscriptionById(Long subId) {
        return subscriptionRepository.findById(subId);
    }

    @Override
    @Transactional
    public void addSubscription(String userLogin, Long pageId) throws EntityDoesnotExistException {
        User user = userService.findUserByLogin(userLogin).orElseThrow(() -> new EntityDoesnotExistException("User not found"));
        Page page = pageService.findPageById(pageId).orElseThrow(() -> new EntityDoesnotExistException("Page not found"));
        subscriptionRepository.save(new Subscription(user, page));
    }

    @Override
    @Transactional
    public void deleteSubscription(Long subId) {
        subscriptionRepository.deleteById(subId);
    }
}
