package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.domain.Page;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/pages")
public class PageRestAdapter {
    private final PageService pageService;

    public ResponseEntity<String> addPage(@RequestBody Page page){
        try {
            pageService.addPage(page.getName(), page.getUrl(), page.getParsingXPath());
            return ResponseEntity.ok("Success");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body("Duplicate Entity: " + e.getMessage());
        }
    }
}

// "users/{login}"
// @PathVariable String login...