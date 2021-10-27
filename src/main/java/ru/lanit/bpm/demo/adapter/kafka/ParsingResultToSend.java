package ru.lanit.bpm.demo.adapter.kafka;

import lombok.Data;

@Data
public class ParsingResultToSend {
    private String parsingResult;
    private String telegramId;

    public ParsingResultToSend() {

    }

    public ParsingResultToSend(String parsingResult, String telegramId) {
        this.parsingResult = parsingResult;
        this.telegramId = telegramId;
    }
}
