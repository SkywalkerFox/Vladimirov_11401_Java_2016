package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.kpfu.itis.PAVEL_VLADIMIROV.Main;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.SuppliesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.SuppliesServiceImpl;

import java.util.Collections;

/**
 * Created by Павел on 01.06.2016.
 */
public class SuppliesController {


    private SuppliesService suppliesService = new SuppliesServiceImpl();
    private Main mainApp;

    @FXML
    private TableView<RequestedSupplies> suppliesTable;

    @FXML
    public TableColumn nameColumn;

    @FXML
    private TableColumn descriptionColumn;


    public void setApp(Main app) {
        this.mainApp = app;

        suppliesTable.setItems(getSupplies());
    }

    public ObservableList<RequestedSupplies> getSupplies() {
        ObservableList<RequestedSupplies> supplies = FXCollections.observableArrayList();
        RequestedSupplies[] requestedSupplies = suppliesService.getAll().getBody();
        Collections.addAll(supplies, requestedSupplies);

        return supplies;
    }
}
