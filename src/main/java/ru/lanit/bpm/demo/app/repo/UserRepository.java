package ru.lanit.bpm.demo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lanit.bpm.demo.domain.ParsingResult;
import ru.lanit.bpm.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom, JpaRepository<User, String> {

    @Query("select u from User u")
    List<User> findSpecialUsers(String lastName);

    //Map<ParsingResult, List<User>>
}
