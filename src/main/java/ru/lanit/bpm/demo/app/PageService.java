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
 * PageService$
 */
package ru.lanit.bpm.demo.app;

import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * todo Document type PageService
 */
public interface PageService {
    void addPage(String name, String url, String parsingXPath) throws DuplicateEntityException;

    List<Page> findAvailablePages();

    void deletePage(Long id);

    Optional<Page> findPageById(Long id);
}
