package ru.lanit.bpm.demo.fw;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.SubscriptionService;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.app.repo.PageRepository;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Map;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = YoDataApplication.class)
@Slf4j
class YoDataApplicationTests {
    @Autowired
    PageService pageService;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParsingResultRepository parsingResultRepository;
    @Autowired
    SubscriptionService subscriptionService;

    @Transactional
    @Test
    void contextLoads() throws DuplicateEntityException, EntityDoesnotExistException {
        pageService.addPage("name", "url", "xpath");
        Page page = pageRepository.findByName("name").orElseThrow();
        assertEquals("name", page.getName());
        log.info("PAGE: {}", page.getName());

        log.info("ALL PAGES: {}", pageService.findAvailablePages().toString());

        userService.addUser("test1", "pass", "Pupa", "Lupa", "puplup");
        log.info("ADDED USER: {}", userService.findUserByLogin("test1").toString());

        subscriptionService.findSubscriptionByUser("DGiba")
                .forEach(context -> log.info("SUBSCRIPTIONS OF DGIBA: {}", context.getPage().getName()));

        pageService.deletePage(2L);
        log.info("PAGE SHOULD NOT EXIST: {}", pageService.findPage(2L));
    }

    @Transactional
    @Test
    void contextLoads_exception() throws DuplicateEntityException {
        try {
            //Arrange
            pageService.addPage("name", "url", "xpath");

            //Act
            Page page = pageRepository.findByName("name").orElseThrow();
            assertEquals(userRepository.findByTelegramId("Zuzler").get().getLastName(), "Гиба");
        } catch (DuplicateEntityException e) {
            return;
        }
        //Assert
        fail("Должны но не поймали ошибку");
    }

    @Transactional
    @Test
    void contextLoads_pr(){
        Map<ParsingResult, List<User>> unsentParsingResults = parsingResultRepository.fetchUnsentResult();
        log.info(unsentParsingResults.toString());
    }
}
