package ru.lanit.bpm.demo.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString
@Getter
@Entity
@Table(name = "parsing_results")
public class ParsingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_parsing_results_id")
    @SequenceGenerator(name = "sq_parsing_results_id", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;
    private Instant parsingDateTime;
    private String result;
    private boolean sent;

    public ParsingResult(Page page, Instant parsingDateTime, String result, boolean sent) {
        this.page = page;
        this.parsingDateTime = parsingDateTime;
        this.result = result;
        this.sent = sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
