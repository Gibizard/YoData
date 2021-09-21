package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.lanit.bpm.demo.app.ParsingResultService;

@RequiredArgsConstructor
@Component("parsePageConditions")
public class ParsePageConditions {
    private final ParsingResultService parsingResultService;

    public int unsentResultsCount(){
        return parsingResultService.unsentResultsCount();
    }
}
