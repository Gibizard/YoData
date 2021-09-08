package ru.lanit.bpm.demo.app.processes.parsepages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.lanit.bpm.demo.adapter.pageparsing.PageParser;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.domain.Page;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component("parseDelegate")
public class ParsePageParse implements JavaDelegate {
    private final PageService pageService;
    private final PageParser pageParser;
    private final ParsingResultService parsingResultService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Parse page started...");

        List<Page> pages = pageService.findAvailablePages();
        pages.forEach(page -> {
            try {
                String urlContent = pageParser.getUrlContent(page.getUrl(), page.getParsingXPath());
                // TODO: 08.09.2021  parsingResultService.saveResult();
            } catch (IOException e) {
                log.error("Error while parsing page", e);
            }
        });
    }
}
