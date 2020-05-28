package br.com.forum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({ ForumApplicationTests.class, HikariIntegrationTest.class })
@ActiveProfiles("test")
public class SuiteTest {

}
