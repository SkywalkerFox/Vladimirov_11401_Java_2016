package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
public interface SentSuppliesService {
    void addSupply(SentSupplies supply);
    void delete(SentSupplies supply);
    SentSupplies getByName(String name);
    List<SentSupplies> getAll();

    List<SentSupplies> getAllForUser(Integer id);
}
