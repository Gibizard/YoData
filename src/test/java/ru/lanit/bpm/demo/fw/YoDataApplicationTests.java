package ru.lanit.bpm.demo.fw;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.bpm.demo.app.PageService;
import ru.lanit.bpm.demo.app.ParsingResultService;
import ru.lanit.bpm.demo.app.SubscriptionService;
import ru.lanit.bpm.demo.app.UserService;
import ru.lanit.bpm.demo.app.impl.DuplicateEntityException;
import ru.lanit.bpm.demo.app.impl.EntityDoesnotExistException;
import ru.lanit.bpm.demo.app.repo.PageRepository;
import ru.lanit.bpm.demo.app.repo.ParsingResultRepository;
import ru.lanit.bpm.demo.app.repo.UserRepository;
import ru.lanit.bpm.demo.domain.Page;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.Subscription;
import ru.lanit.bpm.demo.domain.User;

import java.util.List;
import java.util.Map;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.*;

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
    @Autowired
    ParsingResultService parsingResultService;

/*
    @Transactional
    @Test
    void addUser() throws DuplicateEntityException, EntityDoesnotExistException {
        User user = new User("unit_test_user", "qwerty", "Ivan", "Ivanov", "22");
        userService.addUser(user);
        assertSame(userService.findUserByLogin("unit_test_user").orElseThrow().getFirstName(), user.getFirstName());
    }

    @Transactional
    @Test
    void addPage() throws DuplicateEntityException {
        pageService.addPage("name", "url", "xpath");
        Page page = pageRepository.findByName("name").orElseThrow();
        assertEquals("name", page.getName());
        log.info("PAGE: {}", page.getName());
    }

    @Test
    void findAllPages() {
        assertEquals(2, (long) pageService.findAvailablePages().size());
    }

    @Test
    void findUserSubscriptions() {
        List<Subscription> subList = subscriptionService.findSubscriptionByUser("DGiba");
        subList.forEach(context -> log.info("SUBSCRIPTIONS OF DGIBA: {}", context.getPage().getName()));
        assertEquals(1, subList.size());
    }

    @Transactional
    @Test
    void deletePage() {
        pageService.deletePage(2L);
        assertFalse(pageService.findPageById(2L).isPresent());
    }

    @Transactional
    @Test
    void addSub() throws EntityDoesnotExistException {
        subscriptionService.addSubscription("DGiba", 2L);
        assertEquals(2, subscriptionService.findSubscriptionByUser("DGiba").size());
    }

    @Transactional
    @Test
    void deleteSub() {
        subscriptionService.deleteSubscription(3L);
        assertFalse(subscriptionService.findSubscriptionById(3L).isPresent());
    }

    @Test
    void findUserByLogin() throws EntityDoesnotExistException {
        assertTrue(userService.findUserByLogin("DGiba").isPresent());
    }

    @Transactional
    @Test
    void updatePassword() throws EntityDoesnotExistException {
        String newPass = "new_pass";
        userService.updatePassword("DGiba", newPass);
        assertEquals(newPass, userService.findUserByLogin("DGiba").orElseThrow().getPassword());
    }

    @Transactional
    @Test
    void deleteUser() throws EntityDoesnotExistException {
        userService.deleteUser("DGiba");
    }

    @Test
    void userCheck() {
        assertTrue(userService.checkPasswordByLogin("DGiba", "12345"));
    }

    @Transactional
    @Test
    void unsentResultsCount() {
        Map<ParsingResult, List<User>> parsingResultListMap = parsingResultRepository.fetchUnsentResult();
        parsingResultListMap.forEach((pr, users) -> {
            log.info(pr.toString());
            log.info("Users: ");
            users.forEach(user -> log.info(" - " + user.getLogin()));
        });
        assertEquals(2, parsingResultService.unsentResultsCount());
    }
*/
}
