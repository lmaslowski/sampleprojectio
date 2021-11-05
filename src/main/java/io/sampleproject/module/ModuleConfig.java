package io.sampleproject.module;

import io.sampleproject.module.application.ApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {

    @Bean
    public ApplicationService applicationService() {
        return new ApplicationService();
    }

}
