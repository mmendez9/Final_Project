package p1;

/*
 * Mayra Mendez
 * Database MySQL Final Project
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class Data_Project extends Application {
    Button first = new Button("First");
    Button back = new Button("Back");
    Button next = new Button("Next");
    Button last = new Button("Last");

    public HBox buttons() {
        HBox buts = new HBox(10);
        buts.setPadding(new Insets(10));
        buts.getChildren().addAll(first, back, next, last);

        return buts;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the Accessor to MySQL Database
        DataAccessor dataAccessor = new DataAccessor();

        // Create a TabPane to navigate between the forms
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tab for the students records
        Tab Student = new Tab("Student");
        ArrayList<Pane> panes = new ArrayList<>();
        EventHandler<ActionEvent> Bts = e -> {
            Button b = (Button) e.getSource();
            if (b.getText() == "First") {
                Student.setContent(panes.get(0));
            } else if (b.getText() == "Back"){
                for(int j = 0; j < 5;) {
                    Student.setContent(panes.get(j-1));
                }
            }else if (b.getText() == "Next") {
                for(int j = 0; j < 5;) {
                    Student.setContent(panes.get(j+1));
                }
            }else if (b.getText() == "Last") {
                Student.setContent(panes.get(5));
            }
        };
        for (Student each : dataAccessor.getStudentsList()) {

            GridPane pane = new GridPane();
            pane.setPadding(new Insets(10));
            pane.setVgap(5);
            pane.setHgap(5);

            pane.addRow(0, new Label("Student ID: " + "\t" + each.getStudentID()));
            pane.addRow(1, new Label("First Name: " + "\t" + each.getFirstName()));
            pane.addRow(2, new Label("Last Name: " + "\t" + each.getLastName()));
            pane.addRow(3, new Label("Major: " + "\t" + "\t" + each.getMajor()));
            pane.addRow(4, new Label("Department: " + "\t" + each.getDepartment()));
            pane.addRow(5, buttons());

            Student.setContent(pane);
                first.setOnAction(Bts);
                back.setOnAction(Bts);
                next.setOnAction(Bts);
                last.setOnAction(Bts);

            panes.add(pane);
        }


        // Tab for the course
        Tab Course = new Tab("Course");

        for (Course each : dataAccessor.getCourseList()) {
            GridPane pane2 = new GridPane();
            pane2.setPadding(new Insets(10));
            pane2.setVgap(5);
            pane2.setHgap(5);

            pane2.addRow(0, new Label("CRN: " + "\t" + "\t" + each.getCRN()));
            pane2.addRow(1, new Label("Title: " + "\t" + "\t" + each.getTitle()));
            pane2.addRow(2, new Label("Major: " + "\t" + "\t" + each.getMajor()));
            pane2.addRow(3, new Label("Number: " + "\t" + "\t" + each.getNumber()));
            pane2.addRow(4, new Label("Department: " + "\t" + each.getDepartment()));
            pane2.addRow(5, buttons());

            Course.setContent(pane2);
        }

        // Tab for the enrollment
        Tab Enrollment = new Tab("Enrollment");

        for (Enrollment each : dataAccessor.getEnrollmentList()) {
            GridPane pane3 = new GridPane();
            pane3.setPadding(new Insets(10));
            pane3.setVgap(5);
            pane3.setHgap(5);

            pane3.addRow(0, new Label("Student ID: " + "\t" + each.getStudentID()));
            pane3.addRow(1, new Label("CRN: " + "\t" + "\t" + each.getCRN()));
            pane3.addRow(15, buttons());

            Enrollment.setContent(pane3);
        }

        // Put all tabs together
        tabPane.getTabs().addAll(Student, Course, Enrollment);


        Scene scene = new Scene(tabPane, 250, 200);
        primaryStage.setTitle("Registration DTCC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
