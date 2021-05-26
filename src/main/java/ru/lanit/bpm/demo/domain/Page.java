package ru.lanit.bpm.demo.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
@Getter
@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pages_id")
    @SequenceGenerator(name = "sq_pages_id", allocationSize = 1)
    private Long id;
    private String name;
    private String url;
    @Column(name = "parsing_x_path")
    private String parsingXPath;

    public Page(String name, String url, String parsingXPath) {
        this.name = name;
        this.url = url;
        this.parsingXPath = parsingXPath;
    }
}
