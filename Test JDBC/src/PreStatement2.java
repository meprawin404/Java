import java.sql.*;
import java.util.Scanner;
public class PreStatement2 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String q = "INSERT INTO employee (id,name,job_title,salary) VALUES (?,?,?,?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String job_title = sc.nextLine();
            double salary = sc.nextDouble();
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,job_title);
            preparedStatement.setDouble(4,salary);
            int effect = preparedStatement.executeUpdate();
            if(effect>0){
                System.out.println("Data inserted successfully!");
            }else {
                System.out.println("Data insertation failed!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
