package ru.lanit.bpm.demo.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;

@Service
@RequiredArgsConstructor
public class ParsingResultServiceImpl implements ParsingResultService {
    private final ParsingResultRepository parsingResultRepository;

    @Override
    public void saveResult(Page page, String result) {
        // TODO: 08.09.2021  parsingResultRepository.save(new ParsingResult("","",""));
    }

    @Override
    public void markResultSent(ParsingResult parsingResult) {
        parsingResult.setSent(true);
        parsingResultRepository.save(parsingResult);
    }
}
