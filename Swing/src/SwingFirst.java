import java.awt.*;
import javax.swing.*;

public class SwingFirst {
    public static void main(String[] args){
        new Abc();
    }
}


class Abc extends JFrame
{
    public Abc(){
        JLabel l1 = new JLabel("Hello");
        add(l1);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}