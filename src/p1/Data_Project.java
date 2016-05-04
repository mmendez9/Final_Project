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

import java.util.ArrayList;

public class Data_Project extends Application {

    // Buttons for student tab
    public VBox studentBtns(EventHandler eventHandler) {
        VBox all = new VBox();
        HBox buts = new HBox(10);
        HBox bts = new HBox(10);
        Button first = new Button("First");
        Button back = new Button("Back");
        Button next = new Button("Next");
        Button last = new Button("Last");
        Button add = new Button("Add");
        Button modify = new Button("Modify");
        Button del = new Button("Delete");
        first.setOnAction(eventHandler);
        back.setOnAction(eventHandler);
        next.setOnAction(eventHandler);
        last.setOnAction(eventHandler);
        buts.setPadding(new Insets(10));
        buts.getChildren().addAll(first, back, next, last);
        bts.getChildren().addAll(add, modify, del);
        bts.setAlignment(Pos.CENTER);
        all.getChildren().addAll(buts,bts);
        all.setAlignment(Pos.CENTER);
        return all;
    }

    // Buttons for the course tab
    public VBox courseBtns(EventHandler eventHandler) {
        VBox all = new VBox();
        HBox buts = new HBox(10);
        HBox bts = new HBox(10);
        Button first = new Button("First");
        Button back = new Button("Back");
        Button next = new Button("Next");
        Button last = new Button("Last");
        Button add = new Button("Add");
        Button modify = new Button("Modify");
        Button del = new Button("Delete");
        first.setOnAction(eventHandler);
        back.setOnAction(eventHandler);
        next.setOnAction(eventHandler);
        last.setOnAction(eventHandler);
        buts.setPadding(new Insets(10));
        buts.getChildren().addAll(first, back, next, last);
        bts.getChildren().addAll(add, modify, del);
        bts.setAlignment(Pos.CENTER);
        all.getChildren().addAll(buts,bts);
        all.setAlignment(Pos.CENTER);
        return all;
    }

    // Buttons for the enrollment tab
    public VBox enrollmentBtns(EventHandler eventHandler) {
        VBox all = new VBox();
        HBox buts = new HBox(10);
        HBox bts = new HBox(10);
        Button first = new Button("First");
        Button back = new Button("Back");
        Button next = new Button("Next");
        Button last = new Button("Last");
        Button add = new Button("Add");
        Button modify = new Button("Modify");
        Button del = new Button("Delete");

        first.setOnAction(eventHandler);
        back.setOnAction(eventHandler);
        next.setOnAction(eventHandler);
        last.setOnAction(eventHandler);

        buts.setPadding(new Insets(10));
        buts.getChildren().addAll(first, back, next, last);
        bts.getChildren().addAll(add, modify, del);
        bts.setAlignment(Pos.CENTER);
        all.getChildren().addAll(buts,bts);
        all.setAlignment(Pos.CENTER);
        return all;
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
            for (int j = 0; j <= 4; j++) {
                if (b.getText().equals("First")) {
                    Student.setContent(panes.get(0));
                } else if (b.getText().equals("Back")) {
                    if (panes.get(j).equals(0)) {
                        if (j != 0) {
                            Student.setContent(panes.get(j));
                        } else
                            Student.setContent(panes.get(0));
                    } else if (j != 0)
                        Student.setContent(panes.get(j - 1));

                    System.out.println(j);
                } else if (b.getText().equals("Next")) {
                        Student.setContent(panes.get(j + 1));

                } else if (b.getText().equals("Last")) {
                    Student.setContent(panes.get(4));
                }
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
            pane.addRow(5, studentBtns(Bts));

            panes.add(pane);

            Student.setContent(panes.get(0));
        }


        // Tab for the course
        Tab Course = new Tab("Course");
        ArrayList<Pane> panes2 = new ArrayList<>();
        EventHandler<ActionEvent> Btc = e -> {
            Button b = (Button) e.getSource();
            if (b.getText().equals("First")) {
                Course.setContent(panes2.get(0));
            } else if (b.getText().equals("Back")) {
                for (int j = 0; j <= 4; j++) {
                    Course.setContent(panes2.get(j - 1));
                }
            } else if (b.getText().equals("Next")) {
                Course.setContent(panes2.get(1));

            } else if (b.getText().equals("Last")) {
                Course.setContent(panes2.get(panes2.size() - 1));
            }
        };

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
            pane2.addRow(5, courseBtns(Btc));

            panes2.add(pane2);
            Course.setContent(panes2.get(0));
        }

        // Tab for the enrollment
        Tab Enrollment = new Tab("Enrollment");
        ArrayList<Pane> panes3 = new ArrayList<>();
        EventHandler<ActionEvent> Bte = e -> {
            Button b = (Button) e.getSource();
            if (b.getText().equals("First")) {
                Enrollment.setContent(panes3.get(0));
            } else if (b.getText().equals("Back")) {
                for (int j = 1; j <= panes3.size() - 1; j++) {
                    Enrollment.setContent(panes2.get(j - 1));
                }
            } else if (b.getText().equals("Next")) {
                Enrollment.setContent(panes3.get(1));

            } else if (b.getText().equals("Last")) {
                Enrollment.setContent(panes3.get(panes3.size() - 2));
            }
        };

        for (Enrollment each : dataAccessor.getEnrollmentList()) {
            GridPane pane3 = new GridPane();
            pane3.setPadding(new Insets(10));
            pane3.setVgap(5);
            pane3.setHgap(5);

            pane3.addRow(0, new Label("Student ID: " + "\t" + each.getStudentID()));
            pane3.addRow(1, new Label("CRN: " + "\t" + "\t" + each.getCRN()));
            pane3.addRow(15, enrollmentBtns(Bte));

            panes3.add(pane3);

            Enrollment.setContent(panes3.get(0));
        }

        // Put all tabs together
        tabPane.getTabs().

                addAll(Student, Course, Enrollment);


        Scene scene = new Scene(tabPane, 300, 250);
        primaryStage.setTitle("Registration DTCC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
