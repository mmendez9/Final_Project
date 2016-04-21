package p1;

/*
 * Mayra Mendez
 * Class to get access to the data in MySQL
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessor {

    private Connection connection = null;
    // ArrayList for students
    // Strings to connect to database
    private String url = "//phpmyadmin.cdgwdgkn5fuv.us-west-2.rds.amazonaws.com";
    private String db_name = "db_mayra";
    private String user = "db_mayra";
    private String password = "mm7277";
    private String connect = "jdbc:mysql:" + url + ":3306/" + db_name;


    public DataAccessor() throws DriverError, SQLError, ClassNotFoundException, SQLException, ConnectionError {
        // Load the mysql driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");

        // Connect to the database
        connection = DriverManager.getConnection(connect, user, password);
        System.out.println("Connection Successful");



    }

    public ArrayList<Student> studentsList() throws SQLException {
        // Get information from the database
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM Student ");

        // Display the record set
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            System.out.println("Student ID: " + student.getStudentID(rs.getInt("Student ID")) + "\t" +
                    "\tFirst Name: " + student.getFirstName(rs.getString("First Name")) + "\t" +
                    "\tLast Name: " + student.getLastName(rs.getString("Last Name")));
            students.add(student);
        }
        return students;
    }
}

class DriverError extends Exception {
    public DriverError() {
        super("Driver not loaded");
    }
}

class ConnectionError extends Exception {
    public ConnectionError() {
        super("Connection not successful");
    }
}

class SQLError extends Exception {
    public SQLError() {
        super("SQL Error");
    }
}