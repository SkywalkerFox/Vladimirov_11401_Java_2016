package sample;

import com.sun.javafx.geom.Vec2f;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static java.lang.Math.*;
public class Main extends Application {

    private static Stage stage;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("My Awesome Game");
        stage.setScene(createScene());
        stage.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(15));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    private int windowWidth = 600;
    private int windowHeight = 600;

    private Scene createScene() {
        Group root = new Group();
        for(int i =0; i < 1; i++) {
            root.getChildren().add(createTarget());
        }
        root.getChildren().add(points);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        //KeyValue keyValueX = new KeyValue();

        return new Scene(root, windowWidth, windowHeight);
    }

    private Random random = new Random(); // нам нужен рандом!!

    private ImageView createTarget() {
        Image targetImage = new Image("target.png", 50, 50, false, false);
        ImageView target = new ImageView(targetImage);
        target.setLayoutX(random.nextInt(windowWidth - 100));
        target.setLayoutY(random.nextInt(windowHeight - 50));
        addTranslateListener(target);
        return target;
    }

    private Label points = createPointsLabel();
    private int pointsCount = 0;

    private Label createPointsLabel() {
        Label label = new Label();
        label.setText("Points " + pointsCount);
        label.prefWidth(200);
        label.prefHeight(50);
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(windowWidth - 50);
        label.setLayoutY(windowHeight - 50);
        label.setStyle("-fx-background-color: white;");
        addTranslateListener(label);
        return label;
    }

    private Node node;
    private Vec2f delta;

    boolean isRotate;
    private void addTranslateListener(final Node node) {

        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                points.setText("Points " +  ++pointsCount);
                node.setLayoutX(random.nextInt(windowWidth - 100));
                node.setLayoutY(random.nextInt(windowWidth - 50));
            }
        });

        node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                Main.this.node = node;
                if (mouseEvent.getButton() == MouseButton.SECONDARY){
                    isRotate = true;
                }
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;
                isRotate = false;
            }
        });


        node.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent mouseEvent) {
                if (node != null ) {
                    if (isRotate) {

                        double dx1 = mouseEvent.getSceneX() - node.getLayoutX();
                        double dy1 = mouseEvent.getSceneY() - node.getLayoutY();
                        double l = Math.sqrt(dx1 *dx1 + dy1 *dy1);
                        dx1 /= l;
                        dy1 /= l;

                        double angle = PI/2;
                        double dx2 = sin(angle);
                        double dy2 = cos(angle);

                        double cosA = dx1 * dx2 + dy1 * dy2;
                        angle = acos(cosA);

                        if (dy1 < 0) angle = PI - angle ;
                        node.setRotate(angle / PI * 180);
                    }
                    else {
                        node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                        node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                    }
                }
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
//        long time = System.currentTimeMillis();
//        long closeTime = time + 10000;
//        while (time < closeTime) {
//            time = System.currentTimeMillis();
//        }
//        stage.close();
    }
}
