package p1;

/*
 * Mayra Mendez
 * Enrollment Form
 */


public class Enrollment {
    private int studentID;
    private int CRN;

    public int setStudentID(int ID) {
        studentID = ID;
        return studentID;
    }
    public int getStudentID() {
        return studentID;
    }

    public int setCRN(int crn) {
        CRN = crn;
        return CRN;
    }
    public int getCRN() {
        return CRN;
    }
}
