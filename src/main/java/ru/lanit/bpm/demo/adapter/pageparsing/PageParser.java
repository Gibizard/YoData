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
 * PageParser$
 */
package ru.lanit.bpm.demo.adapter.pageparsing;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface PageParser {
    String getUrlContent(String url, String xPath) throws IOException;
}
