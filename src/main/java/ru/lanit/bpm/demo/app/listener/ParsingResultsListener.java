package ru.lanit.bpm.demo.app.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.demo.adapter.kafka.ParsingResultToSend;
import ru.lanit.bpm.demo.adapter.telegram.TelegramAdapter;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParsingResultsListener {
    private final TelegramAdapter telegramAdapter;

    @KafkaListener(topics = "parsingResultsToSend", groupId = "foo", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(ParsingResultToSend message) {
        log.info("Received Message in group foo: {}, {}", message.getTelegramId(), message.getParsingResult());
        if (message.getTelegramId() != null) {
            telegramAdapter.sendMessage(message.getTelegramId(), "Parsing results: " + message.getParsingResult());
        }
    }
}
