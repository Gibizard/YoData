package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("parsePagesSettings")
public class ParsePagesSettings {
    @Value("${camunda.parse-timer}")
    public String timer;

    public String getTimer() {
        return timer;
    }
}
