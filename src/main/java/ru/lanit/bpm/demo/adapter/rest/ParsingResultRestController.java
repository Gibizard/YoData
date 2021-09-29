package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/parsingResults")
public class ParsingResultRestController {
    private final ParsingResultService parsingResultsService;

    @GetMapping
    public List<ParsingResult> getResults() {
        return parsingResultsService.getAllResults();
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clearResults() {
        parsingResultsService.removeResults();
        return ResponseEntity.ok("Success");
    }
}
