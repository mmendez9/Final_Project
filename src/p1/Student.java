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

    public  int setStudentID(int ID) {
        studentID = ID;
        return studentID;
    }
    public int getStudentID() {
        return studentID;
    }

    public String setFirstName(String FirstName){
        firstName = FirstName;
        return firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String setLastName(String LastName){
        lastName = LastName;
        return lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public String setMajor(String Major){
        major = Major;
        return major;
    }
    public String getMajor() {
        return major;
    }

    public String setDpt(String Dept){
        department = Dept;
        return department;
    }
    public String getDepartment() {
        return department;
    }
}
