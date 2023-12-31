import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddTwoNum extends JFrame {
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JButton btn;

    public AddTwoNum()
    {

    }

    public AddTwoNum(String e){
        super(e);
    }

    public void addComponent()
    {
        l1 = new JLabel("Add Two Number");
        l2 = new JLabel("Enter 1st number");
        l3 = new JLabel("Enter second number");
        l4 = new JLabel();
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        btn = new JButton("Ok");
//        add(l1);
        btn.addActionListener(new Handler());
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(btn);
        add(l4);
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int s = a+b;
            l4.setText("The result is "+s);
        }
    }

    public static void main(String[] args){
        AddTwoNum ad = new AddTwoNum();
        ad.addComponent();
    }
}


//public class AddTwoNum {
//    public static void main(String[] args){
//        new AddNum();
//    }
//}

//class AddNum extends JFrame{
//
//    public AddNum()
//    {
//        JLabel l1 = new JLabel("Enter first number");
//        JLabel l2 = new JLabel("Enter second number");
//        JTextField t1= new JTextField(20);
//        JTextField t2 = new JTextField(20);
//        JButton btn = new JButton("ok");
//        add(l1);
//        add(t1);
//        add(l2);
//        add(t2);
//        add(btn);
//        setSize(300,300);
//        setLayout(new FlowLayout());
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//
//}