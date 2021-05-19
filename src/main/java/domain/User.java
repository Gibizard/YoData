package domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@ToString(exclude = "password")
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    private String login;
    private String password;
    private String fistName;
    private String lastName;
    private String telegramId;
}
