package p1;

/*
 * Mayra Mendez
 * Student Form
 */


public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private String major;
    private String department;

    public int getStudentID(int ID) {
        studentID = ID;
        return studentID;
    }

    public String getFirstName(String FirstName) {
        firstName = FirstName;
        return firstName;
    }

    public String getLastName(String LastName) {
        lastName = LastName;
        return lastName;
    }

    public String getMajor(String Major) {
        major = Major;
        return major;
    }

    public String getDepartment(String dtp) {
        department = dtp;
        return department;
    }
}
