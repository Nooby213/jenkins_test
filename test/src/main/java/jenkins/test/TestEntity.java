package jenkins.test;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private long id;
    private String username;
    private String password;

    public TestEntity() {
    }

    public TestEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
