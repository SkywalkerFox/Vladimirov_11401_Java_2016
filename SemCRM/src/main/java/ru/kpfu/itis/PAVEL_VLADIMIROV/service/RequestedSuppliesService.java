package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
public interface RequestedSuppliesService {
    void addSupply(RequestedSupplies supply);
    void delete(RequestedSupplies supply);
    RequestedSupplies getByName(String name);
    List<RequestedSupplies> getAll();
    List<RequestedSupplies> getAllForUser(Integer id);
    RequestedSupplies getByRequesterIdAndDate(Integer id, String date);
    void changeRequestStatus(Integer id, String status);
    RequestedSupplies getBySendingForm(String name, Integer requesterId, Integer size);
}
