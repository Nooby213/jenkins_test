package jenkins.test;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Transactional
public class TestRepository {
    private final EntityManager em;

    public String makeEntity(String username, String password) {
        TestEntity tn = new TestEntity(username, password);
        em.persist(tn);
        return "Username: " + username + ", Password: " + password;
    }
}
