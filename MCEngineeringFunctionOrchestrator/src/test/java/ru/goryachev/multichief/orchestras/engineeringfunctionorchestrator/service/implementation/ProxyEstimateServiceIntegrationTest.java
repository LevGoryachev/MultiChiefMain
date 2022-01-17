package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.app.WebAppInit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Integration testing with real databases and microservices.
 * Before, make sure that bundleDatabase (this Orchestrator) is started and microservices (ProxyService implementations) are able to respond.
 * Necessary to use Lifecycle.PER_CLASS (@TestInstance) to work with common id (testId variable).
 * An entity with autogenerated ID suppose to be created as LinkedHashMap in the first method (1).
 * The ID will be used in each method (2,4,5).
 * The entity with ID suppose to be deleted in the last one (5) and check if getting by the ID throws an Exception.
 * @author Lev Goryachev
 * @version 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = WebAppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProxyEstimateServiceIntegrationTest {

    private Long testId;

    private final Logger log = LoggerFactory.getLogger(ProxyEstimateServiceIntegrationTest.class);

    @Autowired
    private ProxyEstimateService proxyEstimateService;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEstimateTest(){
        Map<String, Object> newEstimate = new LinkedHashMap<>();
        newEstimate.put("estimateCodeNumber","TestValueAbc");
        newEstimate.put("link","TestValueD");
        Object microserviceResponse = proxyEstimateService.save(newEstimate);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Object, Object> responseMap = objectMapper.convertValue(microserviceResponse, Map.class);
        this.testId = Long.parseLong(responseMap.get("id").toString());

        if (log.isDebugEnabled()) {
            log.debug("ProxyEstimateService" + ", " + "save():" + " " + responseMap.toString());
        }

        Assertions.assertThat(this.testId).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEstimateByIdTest(){
        Object microserviceResponse = proxyEstimateService.getOne(testId);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Object, Object> dtoMap = objectMapper.convertValue(microserviceResponse, Map.class);

        Assertions.assertThat(Long.parseLong(dtoMap.get("id").toString())).isEqualTo(testId);
    }

    @Test
    @Order(3)
    public void getAllEstimatesTest(){
        List<Object> microserviceResponse = proxyEstimateService.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<Object, Object>> dtoMaps = microserviceResponse.stream().map(n ->(Map<Object, Object>) objectMapper.convertValue(n, Map.class)).collect(Collectors.toList());

        Assertions.assertThat(dtoMaps.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEstimateTest(){
        ObjectMapper objectMapper = new ObjectMapper();

        Object oldDto = proxyEstimateService.getOne(testId);
        Map<String, Object> oldDtoMap = objectMapper.convertValue(oldDto, Map.class);
        oldDtoMap.put("estimateCodeNumber","Updated test Value");

        Object dtoUpdated = proxyEstimateService.save(oldDtoMap);

        if (log.isDebugEnabled()) {
            log.debug("ProxyEstimateService" + ", " + "update():" + " " + dtoUpdated.toString());
        }

        Object microserviceResponse = proxyEstimateService.getOne(testId);
        Map<Object, Object> dtoUpdatedReaponse = objectMapper.convertValue(microserviceResponse, Map.class);

        Assertions.assertThat(dtoUpdatedReaponse.get("estimateCodeNumber")).isEqualTo("Updated test Value");
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEstimateTest(){

        Object microserviceResponse = proxyEstimateService.delete(testId);
        if (log.isDebugEnabled()) {
            log.debug("ProxyEstimateService" + ", " + "delete():" + " " + microserviceResponse);
        }
        assertThrows(Exception.class, ()->{proxyEstimateService.getOne(testId);} );
    }
}