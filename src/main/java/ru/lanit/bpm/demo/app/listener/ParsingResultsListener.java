package ru.lanit.bpm.demo.app.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.demo.adapter.kafka.ParsingResultToSend;
import ru.lanit.bpm.demo.adapter.telegram.TelegramAdapter;

@RequiredArgsConstructor
@Service
public class ParsingResultsListener {
    TelegramAdapter telegramAdapter;

    @KafkaListener(topics = "parsingResultsToSend", groupId = "foo", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(ParsingResultToSend message) {
        System.out.println("Received Message in group foo: " + message.getParsingResult());
        telegramAdapter.sendMessage(message.getTelegramId(), "Parsing results: " + message.getParsingResult());
    }
}
