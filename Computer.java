import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;
import java.sql.SQLOutput;

public class Computer {
    String company;
    String c_type;
    Storage st;

    public Computer(String Company, String c_type, Storage st){
        this.company = Company;
        this.c_type = c_type;
        this.st = st;
    }

    public String toString()
    {
        return "Company = "+this.company+" Computer type = "+this.c_type+" Storage type = "+st;
    }

    public static void main(String [] args){
        Storage s = new Storage("1000","T7",true);
        Computer c = new Computer("Dell","laptop",s);
        System.out.println(c);
    }
}

