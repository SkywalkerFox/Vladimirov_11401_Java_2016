package ru.kpfu.itis.PAVEL_VLADIMIROV;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.kpfu.itis.PAVEL_VLADIMIROV.controller.AuthController;
import ru.kpfu.itis.PAVEL_VLADIMIROV.controller.SuppliesController;

import java.io.IOException;

public class Main extends Application {

    private  Stage primaryStage;
    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ISSAdmin");

        showLoginPage();
    }

    private void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/login.fxml"));

        Pane pane = (Pane) loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        AuthController controller = loader.getController();
        controller.setApp(this);
    }

    public void initRootLayout() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/root.fxml"));
            borderPane = (BorderPane) loader.load();

            Scene scene = new Scene(borderPane);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllSupplies() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/supplies.fxml"));
            AnchorPane suppliesView = (AnchorPane) loader.load();
            borderPane.setCenter(suppliesView);

            SuppliesController controller = loader.getController();
            controller.setApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
