package p1;

/*
 * Mayra Mendez
 * Class to get access to the data in MySQL
 */


import java.sql.*;
import java.util.ArrayList;

public class DataAccessor {
    public static void main(String[] args) {
        // ArrayList for students
        ArrayList<Student> students = new ArrayList<>();
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
                Student student = new Student();
                System.out.println("Student ID: " + student.getStudentID(rs.getInt("Student ID")) + "\t" +
                        "\tFirst Name: " + student.getFirstName(rs.getString("First Name")) + "\t" +
                        "\tLast Name: " + student.getLastName(rs.getString("Last Name")));
                students.add(student);

                /*System.out.println("Student ID: " + rs.getString(1) + "\t" + "\tFirst Name: " + rs.getString(2) + "\t" +
                        " \tLast Name: " + rs.getString(3));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error");
        }
    }
}
