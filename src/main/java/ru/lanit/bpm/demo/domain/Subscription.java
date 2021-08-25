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
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_subscription_id")
    @SequenceGenerator(name = "sq_subscription_id", allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    public Subscription(User user, Page page) {
        this.user = user;
        this.page = page;
    }
}
