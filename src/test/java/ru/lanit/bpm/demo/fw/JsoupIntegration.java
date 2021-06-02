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
 * JsoupIntegration$
 */
package ru.lanit.bpm.demo.fw;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lanit.bpm.demo.adapter.pageparsing.JsoupPageParser;
import ru.lanit.bpm.demo.adapter.pageparsing.PageParser;

import java.io.IOException;

/**
 * todo Document type JsoupIntegration
 */
@Slf4j
public class JsoupIntegration {
    private PageParser pageParser;

    @BeforeEach
    public void setUpp() {
        pageParser = new JsoupPageParser();
    }

    @Test
    void getUrlContent_success() throws IOException {
        String result =
                pageParser.getUrlContentt("https://www.cbr.ru/", "//div[@class='main-indicator_rate'][2]/div[contains(@class,'mono-num')][2]/text()");
        log.info(result);
    }
}
