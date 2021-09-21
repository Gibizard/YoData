package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("parsePageSettings")
public class ParsePageSettings {
    @Value("${camunda.parseTimer}")
    public String timer;

    public String getTimer() {
        return timer;
    }
}
