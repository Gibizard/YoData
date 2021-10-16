package ru.lanit.bpm.demo.adapter.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParsingResultToSend {
    private String parsingResult;
    private String telegramId;
}
