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
    private Connection connection = null;
    // Strings to connect to database
    private String url = "//phpmyadmin.cdgwdgkn5fuv.us-west-2.rds.amazonaws.com";
    private String db_name = "db_mayra";
    private String user = "db_mayra";
    private String password = "mm7277";
    private String connect = "jdbc:mysql:" + url + ":3306/" + db_name;

    public Data_Project() throws DriverError, SQLError, ClassNotFoundException, SQLException, ConnectionError {
        // Load the mysql driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");

        // Connect to the database
        connection = DriverManager.getConnection(connect, user, password);
        System.out.println("Connection Successful");
    }

    public ArrayList<Student> getStudentsList() throws SQLException {
        // Get information from the database
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM Student ");

        // Display the record set
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setStudentID(rs.getInt("Student ID"));
            student.setFirstName(rs.getString("First Name"));
            student.setLastName(rs.getString("Last Name"));
            student.setMajor(rs.getString("Major"));
            student.setDpt(rs.getString("Department"));
            students.add(student);
        }
        return students;
    }

    public HBox buttons() {
        HBox buts = new HBox(10);
        buts.setPadding(new Insets(10));
        Button first = new Button("First");
        Button back = new Button("Back");
        Button next = new Button("Next");
        Button last = new Button("Last");

        buts.getChildren().addAll(first, back, next, last);

        return buts;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a TabPane to navigate between the forms
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tab for the students records
        Tab Student = new Tab("Student");

        for (Student each : getStudentsList()) {
            GridPane pane1 = new GridPane();
            pane1.setPadding(new Insets(10));
            pane1.setVgap(5);
            pane1.setHgap(5);
            int id = each.getStudentID();
            String fName = each.getFirstName();
            String lName = each.getLastName();
            String major = each.getMajor();
            String dtp = each.getDepartment();
            pane1.addRow(0, new Label("Student ID: " + id));
            pane1.addRow(1, new Label("First Name: " + fName));
            pane1.addRow(2, new Label("Last Name: " + lName));
            pane1.addRow(3, new Label("Major: " + major));
            pane1.addRow(4, new Label("Department: " + dtp));
            pane1.addRow(5, buttons());
            Student.setContent(pane1);
        }



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
