package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.http.ResponseEntity;
import ru.kpfu.itis.PAVEL_VLADIMIROV.Main;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.AuthService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.AuthServiceImpl;

/**
 * Created by Павел on 01.06.2016.
 */
public class AuthController {

    private Main mainApp;
    private AuthService authService = new AuthServiceImpl();

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField error;

    public Main getApp() {
        return mainApp;
    }

    public void setApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void startApp() {
        mainApp.initRootLayout();
    }

    @FXML
    public void logIn() {
        ResponseEntity<Boolean> responseEntity = authService.logIn(email.getText(), password.getText());

        if (responseEntity.getBody()) {
            startApp();
        } else {
            error.setVisible(true);
        }
    }
}
