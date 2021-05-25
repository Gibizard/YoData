package ru.lanit.bpm.demo.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "demo.ru.lanit.bpm.demo.domain")
public class YoDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoDataApplication.class, args);
    }
}
