package ru.lanit.bpm.demo.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.domain.Page;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/pages")
public class PageRestController {
    private final PageService pageService;

    @PutMapping("/add")
    public ResponseEntity<String> addPage(@RequestBody Page page) {
        try {
            pageService.addPage(page.getName(), page.getUrl(), page.getParsingXPath());
            return ResponseEntity.ok("Success");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body("Duplicate Entity: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Page> getPages() {
        return pageService.findAvailablePages();
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deletePage(@PathVariable Long id) {

        if (pageService.findPageById(id).isPresent()) {
            pageService.deletePage(id);
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.badRequest().body("No such page");
        }
    }
}