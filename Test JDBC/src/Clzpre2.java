import java.sql.*;
import java.util.Scanner;
public class Clzpre2 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/prawin";
        String username = "root";
        String password = "prawin";
        String q = "insert into student(roll,name,faculty,marks) values (?,?,?,?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Esatblished!");
            System.out.println("Enter the Details of Student");
            Scanner sc = new Scanner(System.in);
            int roll = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String faculty = sc.nextLine();
            int marks = sc.nextInt();
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setInt(1,roll);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,faculty);
            preparedStatement.setInt(4,marks);
            int effect = preparedStatement.executeUpdate();
            if (effect>0){
                System.out.println("Data inserted");
            }else {
                System.out.println("Failed to insert");
            }
            con.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
