package ru.lanit.bpm.demo.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParsingResultServiceImpl implements ParsingResultService {
    private final ParsingResultRepository parsingResultRepository;
    private final PageService pageService;

    @Override
    public void saveResult(Page page, String result) {
        parsingResultRepository.save(new ParsingResult(page, Instant.now(), result, false));
    }

    @Override
    public void markResultSent(ParsingResult parsingResult) {
        parsingResult.setSent(true);
        parsingResultRepository.save(parsingResult);
    }

    @Override
    public int unsentResultsCount() {
        return parsingResultRepository.fetchUnsentResult().size();
    }

    @Override
    public boolean isResultChanged(Long pageId, String result) {
        Optional<Page> page = pageService.findPageById(pageId);
        if (page.isPresent()) {
            ParsingResult parsingResult = parsingResultRepository.findFirstByPageOrderByParsingDateTime(page.get());
            if (parsingResult != null) {
                return !parsingResult.getResult().equals(result);
            } else return true;
        } else return true;
    }

    @Override
    public void removeResults() {
        parsingResultRepository.deleteAll();
    }

    @Override
    public List<ParsingResult> getAllResults() {
        return parsingResultRepository.findAll();
    }
}
