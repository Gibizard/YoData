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
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * todo Document type JsoupPageParser
 */
public class JsoupPageParser implements PageParser {
    @Override
    public String getUrlContentt(String url, String xPath) throws IOException {
        Document document = Jsoup.connect(url).get();
        return evaluateXpath(document, xPath);
    }

    private String evaluateXpath(Document document, String xPath) {
        return Xsoup.compile(xPath).evaluate(document).get();
    }
}
