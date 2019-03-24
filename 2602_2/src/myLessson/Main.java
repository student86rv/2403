//package myLessson;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 500;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test"); //заголовок окна
        Canvas canvas = new Canvas(); //площадка для рисования
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        //canvas.getGraphicsContext2D()

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillOval(200, 200, 30, 30);

//        gc.setFill(Color.GREEN);
//        gc.fillRect(250, 250, 30, 30);
//        gc.strokeOval(100, 100, 30, 30);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    System.out.println("left");
                    //x = x - 5;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    System.out.println("right");
                }
            }
        });
    }
}
