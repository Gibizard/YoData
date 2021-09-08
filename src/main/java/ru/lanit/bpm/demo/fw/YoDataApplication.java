package ru.lanit.bpm.demo.fw;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ru.lanit.bpm.demo.domain")
@EnableJpaRepositories(basePackages = {
        "ru.lanit.bpm.demo.adapter.hibernate",
        "ru.lanit.bpm.demo.app.repo"
})

@ComponentScan(basePackages = "ru.lanit.bpm.demo")
@EnableProcessApplication
public class YoDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoDataApplication.class, args);
    }
}
