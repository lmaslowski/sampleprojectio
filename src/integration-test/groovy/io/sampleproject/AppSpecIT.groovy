package io.sampleproject


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AppSpecIT extends Specification {

    @Autowired
    private Environment environment;

    def "application should start properly"() {
        expect:
            null != environment
    }

}
