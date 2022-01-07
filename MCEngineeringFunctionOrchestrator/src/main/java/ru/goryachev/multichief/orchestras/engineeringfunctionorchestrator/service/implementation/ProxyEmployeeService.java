package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service.AbstractProxyService;
import ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.webclient.StaffMicroServiceConnector;

import java.util.Map;

/**
 * The connector provides connection with appropriate microservice (domain).
 * The parameter subDomain defines a segment of url of sub-domain entity.
 * CRUD methods of AbstractProxyService use these parameters
 * @author Lev Goryachev
 * @version 1-0
 */

@Service
@PropertySource("classpath:application.yml")
public class ProxyEmployeeService extends AbstractProxyService {

    @Autowired
    private ProxyEmployeeService(@Value("${urlscheme.multichief.staff.subdomain.employee}") String subDomain, StaffMicroServiceConnector staffMicroServiceConnector) {
        this.subDomain = subDomain;
        this.connector = staffMicroServiceConnector;
    }

    @Override
    public Object save(Map<String, Object> requestDto) {
        //not allowed to use method in MCEngineeringOrchestrator
        return null;
    }

    @Override
    public Object delete(Long bimId) {
        //not allowed to use method in MCEngineeringOrchestrator
        return null;
    }
}
