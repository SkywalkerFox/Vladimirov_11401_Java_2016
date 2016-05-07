package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.SentSuppliesRepository;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
@Service
@ComponentScan("ru.kpfu.itis.PAVEL_VLADIMIROV.repository")
public class SentSuppliesServiceImpl implements SentSuppliesService {

    @Qualifier("sentSuppliesRepository")
    @Autowired
    SentSuppliesRepository sentSuppliesRepository;

    @Override
    public void addSupply(SentSupplies supply) {
        sentSuppliesRepository.save(supply);
    }

    @Override
    public void delete(SentSupplies supply) {

    }

    @Override
    public SentSupplies getByName(String name) {
        return null;
    }

    @Override
    public List<SentSupplies> getAll() {
        return sentSuppliesRepository.findAll();
    }

    @Override
    public List<SentSupplies> getAllForUser(Integer id) {
        return sentSuppliesRepository.getAllForId(id);
    }
}
