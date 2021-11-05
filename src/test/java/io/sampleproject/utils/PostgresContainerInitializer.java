package io.sampleproject.utils;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class PostgresContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    // will be shared between test methods
    @Container
    private static final PostgreSQLContainer P_SQL_CONTAINER = new PostgreSQLContainer(DockerImageName.parse("postgres:11"));

    // will be started before and stopped after each test method
    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer(DockerImageName.parse("postgres:11"))
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    static {
        P_SQL_CONTAINER.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                applicationContext,
                "spring.datasource.url=" + P_SQL_CONTAINER.getJdbcUrl(),
                "spring.datasource.username=" + P_SQL_CONTAINER.getUsername(),
                "spring.datasource.password=" + P_SQL_CONTAINER.getPassword(),
                "spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect"
        );
    }
}
