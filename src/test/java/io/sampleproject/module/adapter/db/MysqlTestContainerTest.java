package io.sampleproject.module.adapter.db;

import io.sampleproject.utils.MysqlContainerInitializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@Slf4j
@ContextConfiguration(initializers = MysqlContainerInitializer.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MysqlTestContainerTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoad() {
        assertNotNull(dataSource);
    }

}
