package ru.goryachev.multichief.orchestras.fieldfunctionorchestrator.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * FieldFunctionOrchestrator main business function:
 * Construction site operations
 * @author Lev Goryachev
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "ru.goryachev.multichief.orchestras.fieldfunctionorchestrator")
@EnableJpaRepositories(basePackages = "ru.goryachev.multichief.orchestras.fieldfunctionorchestrator")
@EntityScan(basePackages = "ru.goryachev.multichief.orchestras.fieldfunctionorchestrator")
public class WebAppInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
