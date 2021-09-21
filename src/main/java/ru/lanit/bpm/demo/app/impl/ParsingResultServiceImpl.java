package ru.lanit.bpm.demo.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ParsingResultServiceImpl implements ParsingResultService {
    private final ParsingResultRepository parsingResultRepository;

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
        ParsingResult parsingResult = parsingResultRepository.findFirstByIdOrderByParsingDateTime(pageId);
        if (parsingResult != null) {
            return !parsingResult.getResult().equals(result);
        } else return false;
    }
}
