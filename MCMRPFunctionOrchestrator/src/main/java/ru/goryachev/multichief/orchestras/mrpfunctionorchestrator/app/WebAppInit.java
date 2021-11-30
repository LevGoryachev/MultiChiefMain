package ru.goryachev.multichief.orchestras.mrpfunctionorchestrator.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * MRPFunctionOrchestrator main business function:
 * Material Resource Planning system functionality
 * @author Lev Goryachev
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "ru.goryachev.multichief.orchestras.mrpfunctionorchestrator")
@EnableJpaRepositories(basePackages = "ru.goryachev.multichief.orchestras.mrpfunctionorchestrator")
@EntityScan(basePackages = "ru.goryachev.multichief.orchestras.mrpfunctionorchestrator")
public class WebAppInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
