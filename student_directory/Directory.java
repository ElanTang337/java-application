import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * @author siyut
 */
public class Directory {
   // List<Student> copyList1 = new ArrayList<Student>();
   // List<Student> copyList2 = new ArrayList<Student>();
    /**
     * a map between andrewid and student.
     */
    private Map<String, Student> student = new HashMap<String, Student>();
    /**
     * a map between the first name of the student and the list of students with the same first name.
     */
    private Map<String, List<Student>> stulist = new HashMap<String, List<Student>>();
    /**
     * a map between the last name of the student and the list of students with the same last name.
     */
    private Map<String, List<Student>> stulist1 = new HashMap<String, List<Student>>();
    /**
     * constructor of the directory.
     */
    public Directory() {
    }
    /**
     * add a student to the directory.
     * @param s
     * a student
     */
    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("student is null!");
        }
        if (student.containsKey(s.getAndrewId())) {
            throw new IllegalArgumentException("Student already exists!");
        } else {
            Student copy = new Student(s.getAndrewId());
            copy.setFirstName(s.getFirstName());
            copy.setLastName(s.getLastName());
            copy.setPhoneNumber(s.getPhoneNumber());
    //    Student copyStudent = (Student) s.clone();
            student.put(s.getAndrewId(), copy);
            if (stulist.containsKey(s.getFirstName())) {
   //         List<Student> copyList1 = stulist00.get(s.getFirstName());
                List<Student> l = stulist.get(s.getFirstName());
                l.add(copy);
   //         copyList1.add(copyStudent);
          //  stulist.put(s.getFirstName(), stulist.get(s.getFirstName()));
            } else {
     //       List<Student> copyList1 = new ArrayList<Student>();
                List<Student> list = new ArrayList<Student>();
                list.add(copy);
    //        copyList1.add(copyStudent);
                stulist.put(s.getFirstName(), list);
   //         stulist00.put(s.getFirstName(), copyList1);
            }
            if (stulist1.containsKey(s.getLastName())) {
     //       List<Student> copyList2 = stulist11.get(s.getLastName());
                List<Student> l = stulist1.get(s.getLastName());
                l.add(copy);
   //         copyList2.add(copyStudent);
          //  stulist.put(s.getLastName(), stulist.get(s.getLastName()));
            } else {
     //       List<Student> copyList2 = new ArrayList<Student>();
                List<Student> list = new ArrayList<Student>();
                list.add(copy);
   //         copyList2.add(copyStudent);
                stulist1.put(s.getLastName(), list);
    //        stulist11.put(s.getLastName(), copyList2);
            }
        }
    }
    /**
     * delete a student from the directory.
     * @param andrewId
     * the andrewid of the student
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException("andrewid is null!");
        } else if (student.containsKey(andrewId)) {
            Student s = student.get(andrewId);
            if (stulist.containsKey(s.getFirstName())) {
                List<Student> l = stulist.get(s.getFirstName());
                l.remove(s);
    //            List<Student> l1 = stulist00.get(s.getFirstName());
     //           l1.remove(s);
                //stulist.remove(s.getFirstName(), stulist.get(s.getFirstName()));
            }
            if (stulist1.containsKey(s.getLastName())) {
                List<Student> l = stulist1.get(s.getLastName());
                l.remove(s);
   //             List<Student> l2 = stulist11.get(s.getLastName());
   //             l2.remove(s);
                //stulist1.remove(s.getLastName(), stulist1.get(s.getLastName()));
            }
            student.remove(andrewId);
        } else {
            throw new IllegalArgumentException("No student existed.");
        }
    }
    /**
     * search a student by andrewid.
     * @param andrewId
     * the andrewid of the student
     * @return
     * return the student that has been searched
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException("andrewid is null!");
        }
        Student stu = student.get(andrewId);
        if (stu == null) {
            return null;
        } else {
            Student copy = (Student) stu.clone();
            return copy;
        }
    }
    /**
     * search the student by first name.
     * @param firstName
     * the first name of the student
     * @return
     * return the list of students that have the same first name
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstname is null!");
        }
        List<Student> list = new ArrayList<Student>();
        List<Student> copy = new ArrayList<Student>();
        list = stulist.get(firstName);
        if (list == null) {
            List<Student> s = Collections.emptyList();
            return s;
        }
        for (int i = 0; i < list.size(); i++) {
            Student st = new Student(list.get(i).getAndrewId());
            st.setFirstName(list.get(i).getFirstName());
            st.setLastName(list.get(i).getLastName());
            st.setPhoneNumber(list.get(i).getPhoneNumber());
            copy.add(st);
        }
  //      List<Student> listCopy = new ArrayList<Student>();
   //     listCopy = stulist00.get(firstName);
        return copy;
            //return Collections.unmodifiableList(list);
            //return new ArrayList<Student>(list);
    }
    /**
     * search the student by last name.
     * @param lastName
     * the last name of the student
     * @return
     * return the list of the students that have the same last name.
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("last name is null!");
        }
        List<Student> list = new ArrayList<Student>();
        List<Student> copy = new ArrayList<Student>();
        list = stulist1.get(lastName);
   //     List<Student> listCopy = new ArrayList<Student>();
     //   listCopy = stulist11.get(lastName);
        if (list == null) {
            List<Student> s = Collections.emptyList();
            return s;
        }
        for (int i = 0; i < list.size(); i++) {
            Student st = new Student(list.get(i).getAndrewId());
            st.setFirstName(list.get(i).getFirstName());
            st.setLastName(list.get(i).getLastName());
            st.setPhoneNumber(list.get(i).getPhoneNumber());
            copy.add(st);
        }
            return copy;
           // return Collections.unmodifiableList(list);
            //return new ArrayList<Student>(list);
    }
    /**
     * size of the directory.
     * @return
     * return the size of the directory
     */
    public int size() {
        return student.size();
    }
}
