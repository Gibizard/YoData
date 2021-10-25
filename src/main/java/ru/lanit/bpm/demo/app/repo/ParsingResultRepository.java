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
 * ParsingResultRepository$
 */
package ru.lanit.bpm.demo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.bpm.demo.adapter.hibernate.ParsingResultRepositoryCustom;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ParsingResultRepository extends CrudRepository<ParsingResult, BigInteger>, ParsingResultRepositoryCustom, JpaRepository<ParsingResult, BigInteger> {
    List<ParsingResult> findParsingResultsBySent(boolean sent);

    ParsingResult findFirstByPageOrderByParsingDateTime(Page page);

    void deleteAll();
}
