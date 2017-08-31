

public class TestStudent {

    public static void main(String[] args) {
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
        System.out.println(d.size());
        d.addStudent(s1);
        d.addStudent(s2);
        d.addStudent(s3);
        d.addStudent(s4);
        d.addStudent(s5);
        System.out.println(d.searchByAndrewId("105"));
        System.out.println(d.searchByAndrewId("101"));
        System.out.println(d.searchByAndrewId("100"));//null
        System.out.println(d.searchByFirstName("Jie"));
        System.out.println(d.searchByFirstName("mei"));//empty list
        System.out.println(d.searchByFirstName("Tom"));
        System.out.println(d.searchByLastName("tang"));//two tang
        System.out.println(d.searchByLastName("dong"));//empty list
        System.out.println(d.size());
        d.deleteStudent("101");
        d.deleteStudent("102");
   //     d.deleteStudent("108");//e
        System.out.println(d.size());

    }

}
