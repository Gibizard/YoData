package ru.lanit.bpm.demo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String>, JpaRepository<User, String> {

    @Query("select u from User u")
    List<User> findSpecialUsers(String lastName);

    //Map<ParsingResult, List<User>>

    boolean existsByLoginAndPassword(String login, String password);

    Optional<User> findUserByTelegramId(String telegramId);
}
