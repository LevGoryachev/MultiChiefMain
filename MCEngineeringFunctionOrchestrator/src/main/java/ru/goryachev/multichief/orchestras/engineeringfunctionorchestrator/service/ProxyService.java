package ru.goryachev.multichief.orchestras.engineeringfunctionorchestrator.service;

import java.util.Map;

/**
 * ProxyService provides CRUD operations between client and third-party services (microservices) using orchestrator.
 * @author Lev Goryachev
 * @version 1.0
 */
public interface ProxyService {
    Iterable<Object> getAll();
    Object getOne(Long id);
    Object save(Map <String, Object> map);
    Object delete(Long id);
}
