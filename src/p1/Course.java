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
    private int credits;

    public int setCRN(int crn){
        CRN = crn;
        return CRN;
    }
    public int getCRN() {
        return CRN;
    }

    public String setTitle(String titl){
        title = titl;
        return title;
    }
    public String getTitle(){
        return title;
    }

    public String setMajor(String mj){
        major = mj;
        return major;
    }
    public String getMajor(){
        return major;
    }

    public int setNum(int no){
        number = no;
        return number;
    }
    public int getNumber() {
        return number;
    }

    public String setDept(String dpt){
        department = dpt;
        return department;
    }
    public String getDepartment(){
        return department;
    }

    public int setCredits(int crd){
        credits = crd;
        return credits;
    }
    public int getCredits(){
        return credits;
    }
}
