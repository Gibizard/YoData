package adapter.hibernate;

import app.repo.UserRepositoryCustom;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Map;

@Component
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Autowired
    EntityManager entityManager;
    @Override
    public Map<String, User> custom() {
        return null;
    }
}
