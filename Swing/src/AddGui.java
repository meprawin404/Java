import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class AddGui{
    public static void main(String [] args){
        new Addition();
    }

}

class Addition extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JLabel l1;
    JButton btn;
    public Addition(){
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        l1 = new JLabel("result");
        btn = new JButton("ok");
        btn.addActionListener(this);
        add(t1);
        add(t2);
        add(btn);
        add(l1);
        setSize(300,300);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        int num1 = Integer.parseInt(t1.getText());
        int num2 = Integer.parseInt(t2.getText());
        int value = num1 + num2;
        l1.setText(value + "");
    }
}