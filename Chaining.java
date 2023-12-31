class C
{
    public C()
    {
        System.out.println("c1");
    }
}

class D extends C
{
    public D()
    {
        this(4);
        System.out.println("D1");
    }

    public D(int a)
    {
        System.out.println("D2");
    }
}

public class Chaining {
    public static void main(String [] arug){
        D objt = new D();
    }
}