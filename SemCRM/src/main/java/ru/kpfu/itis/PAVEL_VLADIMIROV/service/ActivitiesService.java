package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;

import java.util.List;

/**
 * Created by Павел on 07.05.2016.
 */
public interface ActivitiesService {
    void add(Activities activity);
    void delete(Activities activity);
    List<Activities> getAll();

    List<Activities> getLast6();
    List<Activities> getLastLoggedIn();
    List<Activities> getAllWithoutLogin();
}
