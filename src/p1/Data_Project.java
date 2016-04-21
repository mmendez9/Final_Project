package p1;

/*
 * Mayra Mendez
 * Database MySQL Final Project
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Data_Project extends Application {
    public HBox buttons() {
        HBox buts = new HBox(10);
        buts.setPadding(new Insets(10));
        Button[] bts = new Button[4];
        bts[0] = new Button("First");
        bts[1] = new Button("Back");
        bts[2] = new Button("Next");
        bts[3] = new Button("Last");

        buts.getChildren().addAll(bts);
        return buts;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DataAccessor dataAccessor = new DataAccessor();
        // Create a TabPane to navigate between the forms
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tab for the students records
        Tab Student = new Tab("Student");

        GridPane pane1 = new GridPane();
        pane1.setPadding(new Insets(10));
        pane1.setVgap(5);
        pane1.setHgap(5);

        pane1.addRow(0, new Label("Student ID: "));
        pane1.addRow(1, new Label("First Name: "));
        pane1.addRow(2, new Label("Last Name: "));
        pane1.addRow(3, new Label("Major: "));
        pane1.addRow(4, new Label("Department: "));
        pane1.addRow(5, buttons());

        Student.setContent(pane1);

        // Tab for the course
        Tab Course = new Tab("Course");

        GridPane pane2 = new GridPane();
        pane2.setPadding(new Insets(10));
        pane2.setVgap(5);
        pane2.setHgap(5);

        pane2.addRow(0, new Label("CRN: "));
        pane2.addRow(1, new Label("Title: "));
        pane2.addRow(2, new Label("Major: "));
        pane2.addRow(3, new Label("Number: "));
        pane2.addRow(4, new Label("Department: "));
        pane2.addRow(5, buttons());

        Course.setContent(pane2);

        // Tab for the enrollment
        Tab Enrollment = new Tab("Enrollment");

            GridPane pane3 = new GridPane();
            pane3.setPadding(new Insets(10));
            pane3.setVgap(5);
            pane3.setHgap(5);

            pane3.addRow(0, new Label("Student ID"));
            pane3.addRow(1, new Label("CRN: "));
            pane3.addRow(15, buttons());

            Enrollment.setContent(pane3);

        // Put all tabs together
        tabPane.getTabs().addAll(Student, Course, Enrollment);


        Scene scene = new Scene(tabPane, 250, 200);
        primaryStage.setTitle("Registration DTCC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
