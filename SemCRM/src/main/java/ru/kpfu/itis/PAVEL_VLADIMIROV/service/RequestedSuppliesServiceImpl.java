package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.RequestedSuppliesRepository;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
@Service
@ComponentScan("ru.kpfu.itis.PAVEL_VLADIMIROV.repository")
public class RequestedSuppliesServiceImpl implements RequestedSuppliesService {

    @Qualifier("requestedSuppliesRepository")
    @Autowired
    RequestedSuppliesRepository requestedSuppliesRepository;

    @Override
    public void addSupply(RequestedSupplies supply) {
        requestedSuppliesRepository.save(supply);
    }

    @Override
    public void delete(RequestedSupplies supply) {

    }

    @Override
    public RequestedSupplies getByName(String name) {
        return null;
    }

    @Override
    public List<RequestedSupplies> getAll() {
        return requestedSuppliesRepository.findAll();
    }

    @Override
    public List<RequestedSupplies> getAllForUser(Integer id) {
        return requestedSuppliesRepository.getAllForId(id);
    }

    @Override
    public RequestedSupplies getByRequesterIdAndDate(Integer id, String date) {
        return requestedSuppliesRepository.getOneByRequesterIdAndDate(id, date);
    }

    @Override
    @Transactional
    @Modifying
    public void changeRequestStatus(Integer id, String status) {
        requestedSuppliesRepository.updateRequestStatusById(id, status);
    }

    @Override
    public RequestedSupplies getBySendingForm(String name, Integer requesterId, Integer size) {
        return requestedSuppliesRepository.getOneBySendingFormParams(name, requesterId, size);
    }
}
