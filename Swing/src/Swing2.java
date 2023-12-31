import java.awt.*;
import javax.swing.*;

public class Swing2 {
    public static void main(String[] args){
        new Abc1();
    }
}

class Abc1 extends JFrame
{
    public Abc1()
    {
        setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Hello");
        JLabel l2 = new JLabel("welcome prawin");
        setSize(400,400);


        add(l1);
        add(l2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
