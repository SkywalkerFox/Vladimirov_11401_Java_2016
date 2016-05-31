package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.http.ResponseEntity;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;

/**
 * Created by Павел on 31.05.2016.
 */
public interface RequestedSuppliesService {
    ResponseEntity<RequestedSupplies[]> getAll();
    void addSupply(String name, String description, String size);
}
