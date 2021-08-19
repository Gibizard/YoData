package ru.lanit.bpm.demo.fw;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.repo.PageRepository;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.Page;

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
    UserRepository userRepository;

    @Transactional
    @Test
    void contextLoads() throws DuplicateEntityException {
        pageService.addPage("name", "url", "xpath");

        Page page = pageRepository.findByName("name").orElseThrow();
        assertEquals("name", page.getName());
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
}
