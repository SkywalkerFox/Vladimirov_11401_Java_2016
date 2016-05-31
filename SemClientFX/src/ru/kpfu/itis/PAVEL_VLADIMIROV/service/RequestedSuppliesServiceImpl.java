package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;

/**
 * Created by Павел on 31.05.2016.
 */
@Service
public class RequestedSuppliesServiceImpl implements RequestedSuppliesService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<RequestedSupplies[]> getAll() {
        return restTemplate.postForEntity("http://localhost:8080/api/supplies", null, RequestedSupplies[].class);
    }

    @Override
    public void addSupply(String name, String description, String size) {
        MultiValueMap<String, Object> supplyParameters = new LinkedMultiValueMap<>();
        supplyParameters.add("name", name);
        supplyParameters.add("description", description);
        supplyParameters.add("size", size);

        restTemplate.postForEntity("http://localhost:8080/api/add", supplyParameters, null);
    }
}
