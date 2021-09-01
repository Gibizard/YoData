package ru.lanit.bpm.demo.adapter.pageparsing;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
class JsoupPageParserTest {
    PageParser pageParser;

    @BeforeEach
    void setUp() {
        pageParser = new JsoupPageParser();
    }

    @Test
    void getUrlContent_success() throws IOException {
        String result = pageParser.getUrlContent(
                "https://www.cbr.ru/",
                "//div[@class='main-indicator_rate'][2]/div[contains(@class,'mono-num')][2]/text()"
        );
        log.info(result);
        assertFalse(result.isEmpty());
    }

}