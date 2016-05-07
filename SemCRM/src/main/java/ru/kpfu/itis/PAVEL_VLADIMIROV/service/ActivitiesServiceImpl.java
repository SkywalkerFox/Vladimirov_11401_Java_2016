package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.ActivitiesRepository;

import java.util.List;

/**
 * Created by Павел on 07.05.2016.
 */
@Service
@ComponentScan("ru.kpfu.itis.PAVEL_VLADIMIROV.repository")
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    ActivitiesRepository activitiesRepository;

    @Override
    public void add(Activities activity) {
        activitiesRepository.save(activity);
    }

    @Override
    public void delete(Activities activity) {

    }

    @Override
    public List<Activities> getAll() {
        return activitiesRepository.findAll();
    }

    @Override
    public List<Activities> getLast6() {
        List<Activities> activities = getAll();
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getType().equals("login") || activities.get(i).getUserId() == 7) {
                activities.remove(i);

            }
        }
        if (activities.size() > 6) {
            for (int i = activities.size() - 6; i > 0; i--) {
                activities.remove(i);
            }
        }
        return activities;
    }

    @Override
    public List<Activities> getLastLoggedIn() {
        List<Activities> activities = getAll();
        for (int i = 0; i < activities.size(); i++) {
            if (!activities.get(i).getType().equals("login") || activities.get(i).getUserId() == 7) {
                activities.remove(i);

            }
        }
        if (activities.size() > 5) {
            for (int i = activities.size() - 5; i > 0; i--) {
                activities.remove(i);
            }
        }
        return activities;
    }

    @Override
    public List<Activities> getAllWithoutLogin() {
        List<Activities> activities = getAll();
        for (Activities activity : activities) {
            if (activity.getType().equals("login")) {
                activities.remove(activity);
            }
        }
        return activities;
    }
}
