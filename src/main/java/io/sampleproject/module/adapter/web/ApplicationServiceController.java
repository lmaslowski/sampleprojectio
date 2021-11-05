package io.sampleproject.module.adapter.web;

import io.sampleproject.module.application.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApplicationServiceController {

    private final ApplicationService applicationService;
}
