package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * EngineeringFunctionOrchestrator main business function:
 * Design-engineering, building information model developing
 * @author Lev Goryachev
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
@EnableJpaRepositories(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
@EntityScan(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
public class WebAppInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
