package p1;

/*
 * Created by mmendez9 on 4/14/2016.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class Data_Project extends Application{
    Button first = new Button("First");
    Button back = new Button("Back");
    Button next = new Button("Next");
    Button last = new Button("Last");

    public static void main(String[] args) {

        // Strings to connect to database
        String url = "//phpmyadmin.cdgwdgkn5fuv.us-west-2.rds.amazonaws.com";
        String db_name = "db_mayra";
        String user = "db_mayra";
        String password = "mm7277";
        String connect = "jdbc:mysql:" + url + ":3306/" + db_name;

        Connection connection = null;
        // Load the mysql driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Driver not loaded");
        }

        // Connect to the database
        try {
            connection = DriverManager.getConnection(connect, user, password);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection not successful");
        }
        // Get information from the database
        try (Statement s = connection.createStatement()){
            ResultSet rs = s.executeQuery("SELECT * FROM Student ");

            // Display the record set
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getString(1) + "\t" + "\tFirst Name: " + rs.getString(2) + "\t" +
                        " \tLast Name: " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        EventHandler<ActionEvent> firstButton = e -> {
            Scene scene1 = new Scene(getStudentForm(), 350, 250);
            primaryStage.setScene(scene1);
            primaryStage.show();
        };

        EventHandler<ActionEvent> nextButton = e -> {
            if (e.getSource().equals(getStudentForm())) {
                Scene scene = new Scene(getCourseForm(), 350, 250);
                primaryStage.setScene(scene);
                primaryStage.show();
            } else if (e.getSource() == getCourseForm()) {
                Scene scene = new Scene(getEnrollmentForm(), 350, 250);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        };

        EventHandler<ActionEvent> lastButton = e -> {
            Scene scene = new Scene(getEnrollmentForm(), 350, 250);
            primaryStage.setScene(scene);
            primaryStage.show();
        };

        first.setOnAction(firstButton);
        next.setOnAction(nextButton);
        last.setOnAction(lastButton);
        Scene scene = new Scene(getStudentForm(), 350, 250);
        primaryStage.setTitle("Registration DTCC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane getStudentForm() {
        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setHgap(5);
        pane1.setVgap(5);

        pane1.setStyle("-fx-font: 14 arial");
        pane1.addRow(0, new Label("Student ID: "), new TextField());
        pane1.addRow(1, new Label("First Name: "), new TextField());
        pane1.addRow(2, new Label("Last Name: "), new TextField());
        pane1.addRow(3, new Label("Major: "), new TextField());
        pane1.addRow(4, new Label("Department: "), new TextField());


        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().add(pane1);

        first.setStyle("-fx-font: 18 arial");
        back.setStyle("-fx-font: 18 arial");
        next.setStyle("-fx-font: 18 arial");
        last.setStyle("-fx-font: 18 arial");

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(first,back, next, last);

        BorderPane pane = new BorderPane();
        pane.setTop(vBox);
        pane.setBottom(hBox);

        return pane;
    }

    private Pane getCourseForm() {
        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setHgap(5);
        pane1.setVgap(5);

        pane1.setStyle("-fx-font: 14 arial");
        pane1.addRow(0, new Label("CRN: "), new TextField());
        pane1.addRow(1, new Label("Title: "), new TextField());
        pane1.addRow(2, new Label("Major: "), new TextField());
        pane1.addRow(3, new Label("Number: "), new TextField());
        pane1.addRow(4, new Label("Department: "), new TextField());


        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().add(pane1);


        first.setStyle("-fx-font: 18 arial");
        back.setStyle("-fx-font: 18 arial");
        next.setStyle("-fx-font: 18 arial");
        last.setStyle("-fx-font: 18 arial");

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(first,back, next, last);

        BorderPane pane = new BorderPane();
        pane.setTop(vBox);
        pane.setBottom(hBox);

        return pane;
    }

    private Pane getEnrollmentForm() {
        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.setHgap(5);
        pane1.setVgap(5);

        pane1.setStyle("-fx-font: 14 arial");
        pane1.addRow(0, new Label("Student ID: "), new TextField());
        pane1.addRow(1, new Label("CRN: "), new TextField());


        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().add(pane1);

        first.setStyle("-fx-font: 18 arial");
        back.setStyle("-fx-font: 18 arial");
        next.setStyle("-fx-font: 18 arial");
        last.setStyle("-fx-font: 18 arial");

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(first,back, next, last);

        BorderPane pane = new BorderPane();
        pane.setTop(vBox);
        pane.setBottom(hBox);

        return pane;
    }

}
