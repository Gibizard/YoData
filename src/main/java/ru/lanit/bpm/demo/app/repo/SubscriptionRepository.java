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
 * SubscriptionRepo$
 */
package ru.lanit.bpm.demo.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.bpm.demo.domain.Subscription;

import java.util.List;

/**
 * todo Document type SubscriptionRepo
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    List<Subscription> findByUserLogin(String userLogin);
}
