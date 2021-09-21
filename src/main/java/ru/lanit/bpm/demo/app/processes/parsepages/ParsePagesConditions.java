package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.lanit.bpm.demo.app.ParsingResultService;

@RequiredArgsConstructor
@Component("parsePagesConditions")
public class ParsePagesConditions {
    private final ParsingResultService parsingResultService;

    public int unsentResultsCount(){
        return parsingResultService.unsentResultsCount();
    }
}
