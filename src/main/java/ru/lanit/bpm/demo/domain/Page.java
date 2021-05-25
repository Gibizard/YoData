package ru.lanit.bpm.demo.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
@Getter
@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;
    private String parsingXPath;
}
