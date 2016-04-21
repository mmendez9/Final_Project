package p1;

/*
 * Mayra Mendez
 * Course form
 */


public class Course  {
    private int CRN;
    private String title;
    private String major;
    private int number;
    private String department;

    public int getCRN(int crn) {
        CRN = crn;
        return CRN;
    }

    public String getTitle(String name){
        title = name;
        return title;
    }

    public String getMajor(String Major){
        major = Major;
        return major;
    }

    public int getNumber(int no) {
        number = no;
        return number;
    }

    public String getDepartment(String dpt){
        department = dpt;
        return department;
    }
}
