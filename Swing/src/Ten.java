import java.sql.SQLOutput;

interface DemoAno
{
    public void method1();
//    public void method2();
}

//class AnoDemo implements DemoAno
//{
//    public void method1(){
//        System.out.println("method 1");
//    }
//
//    public void method2(){
//        System.out.println("mehtod 2");
//    }
//}

public class Ten {
    public static void main(String [] args){
//        AnoDemo a = new AnoDemo();
//        a.method1();

//        DemoAno obj = new DemoAno(){
//            public void method1(){
//                System.out.println("method 1");
//            }
//
//            public void method2(){
//                System.out.println("method 2");
//            }
//
//        };
//
//        obj.method1();
//        obj.method2();


        DemoAno obj = ()->{
            System.out.println("method 1");
        };

        obj.method1();
    }
}
