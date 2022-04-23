package io.sampleproject.adapter.web

import io.sampleproject.module.adapter.web.ApplicationServiceController
import io.sampleproject.module.application.ApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@WebMvcTest(controllers = [ApplicationServiceController.class])
class ApplicationServiceControllerIT extends Specification {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationService applicationService;

    def "context should start properly"() {
        expect:
            null != environment
            null != mvc
            null != applicationService
    }

    @TestConfiguration
    static class StubConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        ApplicationService applicationServiceTest() {
            def stub = detachedMockFactory.Stub(ApplicationService)
            return stub
        }
    }
}
