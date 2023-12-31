package inheritance;
//class Person
//{
//    private String name;
//    private int age;
//
//    public Person()
//    {
//        this.name = "acb";
//        this.age = 0;
//    }
//
//    public Person(String name, int age)
//    {
//        this.name = name;
//        this.age = age;
//    }
//}
//
//class Teacher extends Person
//{
//    private String subject;
//    private float  salary;
//
//    public Teacher()
//    {
//
//    }
//
//    public Teacher(String subject, float salary)
//    {
//        this.subject = subject;
//        this.salary = salary;
//    }
//
//    public Teacher(String name, int age, String subject,float salary){
//        super(name,age);
//        this.subject = subject;
//        this.salary = salary;
//    }
//
//
//}

public class Prawin {
    public static void main(String [] args){
        inheritance.Employee E = new inheritance.Employee("Rahul",1,1200);
        inheritance.Teacher T = new inheritance.Teacher("Subhash",2,2000,3);
        System.out.println(E.getDetails());
        System.out.println(T.getDetails());
    }
}