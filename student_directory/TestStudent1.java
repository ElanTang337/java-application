import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
public class TestStudent1 {

    public static void main(String[] args) {
        List<Student> stu = new ArrayList<Student>();
        Student s1 = new Student("101");
        s1.setFirstName("Tom");
        s1.setLastName("Lee");
        s1.setPhoneNumber("12345678");
        Student s2 = new Student("102");
        s2.setFirstName("Tom");
        s2.setLastName("Jin");
        s2.setPhoneNumber("12345638");
        Student s3 = new Student("103");
        s3.setFirstName("Jie");
        s3.setLastName("Chen");
        s3.setPhoneNumber("1238967888");
        Student s4 = new Student("104");
        s4.setFirstName("shu");
        s4.setLastName("tang");
        s4.setPhoneNumber("1238969888");
        Student s5 = new Student("105");
        s5.setFirstName("yu");
        s5.setLastName("tang");
        s5.setPhoneNumber("1238237888");
        Directory d = new Directory();
      //  System.out.println(d.size());
        d.addStudent(s1);
     //   s1.setFirstName("fufufufufufufu");
        d.addStudent(s2);
        d.addStudent(s3);
        d.addStudent(s4);
        d.addStudent(s5);
      //  System.out.println(s1);
      //  System.out.println(d.searchByAndrewId("101"));
        //d.addStudent(null);
      //  System.out.println(d.searchByAndrewId("105"));
     //   System.out.println(d.searchByAndrewId("101"));
      //  System.out.println(d.searchByAndrewId("100"));//null
      //  System.out.println(d.searchByFirstName("Jie"));
      //  System.out.println(d.searchByFirstName("mei"));//empty list
     //   System.out.println(d.searchByFirstName("Tom"));
        System.out.println(d.searchByLastName("tang"));//two tang
     //   System.out.println(d.searchByLastName("dong"));//empty list
     //   System.out.println(d.size());
      //  System.out.println("-------------------------------");
        stu = d.searchByLastName("tang");
        int x = stu.indexOf(s4);
        System.out.println(x);
      //  Student st = stu.get(x);
      //  st.setPhoneNumber("whatisthematterwithmyjava!!!!!!!!");
      //  stu.add(s1);
        System.out.println(d.searchByLastName("tang"));
   //     System.out.println(stu);
     //   System.out.println("-------------------------------");
   //     Student st1 = d.searchByAndrewId("105");
    //    st1.setFirstName("xiaobaobaobao");
    //    System.out.println(d.searchByAndrewId("105"));
       // d.deleteStudent("101");
       // d.deleteStudent("103");
       // d.deleteStudent("105");
   //     d.deleteStudent("108");//e
  //      System.out.println("-------------------------------");
     //   System.out.println(d.searchByAndrewId("104"));
       // System.out.println(d.searchByAndrewId("101"));
    //    System.out.println(d.searchByFirstName("Tom"));
   //     System.out.println(d.searchByLastName("tang"));
   //     System.out.println(d.size());

    }

}

