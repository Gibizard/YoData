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
import ru.lanit.bpm.demo.app.repo.PageRepository;
import ru.lanit.bpm.demo.domain.Page;

import java.util.List;

/**
 * todo Document type PageServiceImpl
 */
@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;


    @Transactional
    @Override
    public void addPage(String name, String url, String parsingXPath) throws DuplicateEntityException {
        if (pageRepository.findByName(name).isPresent()){
            throw new DuplicateEntityException("Page already exist");
        }
        Page page = new Page(name, url, parsingXPath);
        pageRepository.save(page);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Page> findAvailablePages() {
        return pageRepository.findAll();
    }

    @Transactional()
    @Override
    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
