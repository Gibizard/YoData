package ru.lanit.bpm.demo.app;

import lombok.RequiredArgsConstructor;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

//@RequiredArgsConstructor
public interface ParsingResultService {
    //private final ParsingResultRepository parsingResultRepository;

    void saveResult(Page page, String result);

    void markResultSent(ParsingResult parsingResult);

    int unsentResultsCount();

    boolean isResultChanged(Long pageId, String result);

    void removeResults();

    List<ParsingResult> getAllResults();
}
