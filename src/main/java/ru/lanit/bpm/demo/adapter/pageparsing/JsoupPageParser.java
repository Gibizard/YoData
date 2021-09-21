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
package ru.lanit.bpm.demo.adapter.pageparsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;

@Component
public class JsoupPageParser implements PageParser {
    @Override
    public String getUrlContent(String url, String xPath) throws IOException {
        Document document = Jsoup.connect(url).get();
        return evaluateXPath(document, xPath);
    }

    private String evaluateXPath(Document document, String xPath) {
        return Xsoup.compile(xPath).evaluate(document).get();
    }
}
