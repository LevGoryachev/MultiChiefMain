package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * EngineeringFunctionOrchestrator main business function:
 * Design-engineering, building information model developing
 * The Service combines data (using IDs) in association tables (table-binders) in case of business needs;
 * manages business-processes using BPMN;
 * compose/decompose documents using other services.
 * @author Lev Goryachev
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
@EnableJpaRepositories(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
@EntityScan(basePackages = "ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator")
public class WebAppInit extends SpringBootServletInitializer {

    @Bean
    //@Scope("prototype")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
