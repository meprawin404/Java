//public class Run {
//    public static void main(String [] args){
//        Outer.Inner o1 = new Outer.Inner();
//        o1.f1();
//    }
//}
//
//
//class Outer
//{
//    static class Inner
//    {
//        void f1(){
//            System.out.println("ifun");
//        }
//    }
//}



public class Run
{
    public static void main(String [] args){
        Outer out = new Outer();
        Outer.Inner o1 = out.new Inner();
        o1.f2(); 
    }
}

class Outer
{
    class Inner
    {
        void f2(){
            System.out.println("ifun non static");
        }
    }
}