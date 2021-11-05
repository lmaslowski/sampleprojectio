package io.sampleproject.utils;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class MysqlContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    // will be shared between test methods
    @Container
    private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer(DockerImageName.parse("mysql:8"));

    static {
        MY_SQL_CONTAINER.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                applicationContext,
                "spring.datasource.url=" + MY_SQL_CONTAINER.getJdbcUrl(),
                "spring.datasource.username=" + MY_SQL_CONTAINER.getUsername(),
                "spring.datasource.password=" + MY_SQL_CONTAINER.getPassword(),
                "spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect"
        );
    }
}
