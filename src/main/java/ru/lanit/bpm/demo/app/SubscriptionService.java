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
 * SubscriptionService$
 */
package ru.lanit.bpm.demo.app;

import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.Subscription;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

/**
 * todo Document type SubscriptionService
 */
public interface SubscriptionService {
    List<Subscription> findSubscriptionByUser(String userLogin);
    
    void addSubscription(String userLogin, Long pageId) throws EntityDoesnotExistException;
}
