//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//public class AddTwoNum2 extends JFrame{
//    public AddTwoNum2(){
//        JLabel l1 = new JLabel("Enter first number");
//        JLabel l2 = new JLabel("Enter second number");
//        JLabel l3 = new JLabel();
//        TextField t1 = new TextField();
//        TextField t2 = new TextField();
//        JButton btn = new JButton("Ok");
//        setSize(300,400);
//        setLayout(new FlowLayout());
//        setVisible(true);
//        add(l1);
//        add(t1);
//        add(l2);
//        add(t2);
//        btn.addActionListener(new Handler());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    class Handler implements ActionListener {
//        public void actionPerformed(ActionEvent e){
//            int a = Integer.parseInt(t1.getText());
//            int b = Integer.parseInt(t2.getText());
//            int sum = a+b;
//            l3.setText("The result is "+sum);
//        }
//
//    }
//
//    public static void main(String[] args){
//        new AddTwoNum2();
//    }
//}
