package ru.lanit.bpm.demo.fw;

import app.repo.UserRepository;
import domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = YoDataApplication.class)
@Slf4j
class YoDataApplicationTests {
    @Test
    void contextLoads() {
    }
}
