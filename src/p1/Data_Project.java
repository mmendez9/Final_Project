package p1;

/*
 * Created by mmendez9 on 4/14/2016.
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Data_Project extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setHgap(5);
        pane1.setVgap(5);

        pane1.setStyle("-fx-font: 14 arial");
        pane1.addRow(0, new Label("Student ID: "));
        pane1.addRow(1, new Label("First Name: "));
        pane1.addRow(2, new Label("Last Name: "));
        pane1.addRow(3, new Label("Major: "));
        pane1.addRow(4, new Label("Department: "));


        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().add(pane1);

        Button first = new Button("First");
        Button back = new Button("Back");
        Button next = new Button("Next");
        Button last = new Button("Last");

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(first,back, next, last);

        BorderPane pane = new BorderPane();
        pane.setTop(vBox);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Registration DTCC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
