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
import ru.lanit.bpm.demo.domain.ParsingResult;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component("parseDelegate")
public class ParsePageParse implements JavaDelegate {
    private final PageService pageService;
    private final PageParser pageParser;
    private final ParsingResultService parsingResultService;

    /**
     * Парсит все страницы, требующие парсинга.
     * Записывает результаты парсинга в БД.
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Parse page started...");

        List<Page> pages = pageService.findAvailablePages();
        pages.forEach(page -> {
            try {
                String urlContent = pageParser.getUrlContent(page.getUrl(), page.getParsingXPath());
                if (isParsingResultChanged(page.getId(), urlContent)) {
                    parsingResultService.saveResult(page, urlContent);
                } else log.info("Parsing result was not changed");
            } catch (IOException e) {
                log.error("Error while parsing page", e);
            }
        });
    }

    public boolean isParsingResultChanged(Long pageId, String result) {
        return parsingResultService.isResultChanged(pageId, result);
    }
}
