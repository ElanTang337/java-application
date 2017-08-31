/**
 * @author siyut
 */
public class Student implements Cloneable {
    /**
     * andrewid.
     */
    private String andrewid;
    /**
    * firstname of the student.
    */
    private String firstname;
    /**
     * lastname of the student.
     */
    private String lastname;
    /**
     * phone number of the student.
     */
    private String phonenumber;
    /**
     * constructor of the Student.
     * @param andrewId
     * andrewid of the student
     */
    public Student(String andrewId) {
        andrewid = andrewId;
    }
    /**
     * deep copy.
     */
    @Override
    public Object clone() {
        Student stu = new Student(andrewid);
        stu.andrewid = this.andrewid;
        stu.firstname = this.firstname;
        stu.lastname = this.lastname;
        stu.phonenumber = this.phonenumber;
        return stu;
    }
    /**
     * helper method to validate.
     * @param s
     * first name, last name or phone number
     */
    private static void validate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("string is null!");
        }
        if (s.equals(" ")) {
            throw new IllegalArgumentException("empty string!");
        }
        if (s.trim().equals(" ")) {
            throw new IllegalArgumentException("empty string!");
        }
    }
    /**
     * set the firstname of the student.
     * @param s
     * first name of the student
     */
    public void setFirstName(String s) {
        validate(s);
        firstname = s;
    }
    /**
     * set the last name of the student.
     * @param s
     * last name of the student
     */
    public void setLastName(String s) {
        validate(s);
        lastname = s;
    }
    /**
     * set the phone number of the student.
     * @param s
     * phone number of the student
     */
    public void setPhoneNumber(String s) {
        validate(s);
        phonenumber = s;
    }
    /**
     * get the andrew id of the student.
     * @return
     * return the andrew id
     */
    public String getAndrewId() {
        return andrewid;
    }
    /**
     * get the fist name of the student.
     * @return
     * return the first name
     */
    public String getFirstName() {
        return firstname;
    }
    /**
     * get the last name of the student.
     * @return
     * return the last name
     */
    public String getLastName() {
        return lastname;
    }
    /**
     * get the phone number of the student.
     * @return
     * return the phone number
     */
    public String getPhoneNumber() {
        return phonenumber;
    }
    @Override
    public String toString() {
        return firstname + " " + lastname + " (Andrew ID: " + andrewid + ", Phone Number: " + phonenumber + ")";
    }
}
