package at.nacs.lechef.logic;

import at.nacs.lechef.logic.user.UserManager;
import at.nacs.lechef.persistence.model.User;
import at.nacs.lechef.persistence.repository.UserRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata2")
class UserManagerTest {

  @Autowired
  UserManager userManager;

  @Autowired
  UserRepository repository;

  @Setter
  User user;

  @Setter
  User user2;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.save(user);
  }

  @Test
  void save() {
    User savedUser = userManager.save(user2);
    assertNotNull(savedUser.getId());
    assertEquals(repository.findAll().size(), 2);
  }

}