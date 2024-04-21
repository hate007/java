import java.util.Hashtable;
import java.util.Enumeration;

public class s5q1 {
    public static void main(String[] args) {
        Hashtable<String, String> studentTable = new Hashtable<>();

        studentTable.put("7020180539", "Amanvaa");
        studentTable.put("8888888888", "Eight");
        studentTable.put("3706551077", "Insanne");

        System.out.println("Student Details:");
        Enumeration<String> mobileNumbers = studentTable.keys();
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentTable.get(mobileNumber);
            System.out.println( "Student Name: " + studentName+ ", Mobile Number: " + mobileNumber);
        }
    }
}
