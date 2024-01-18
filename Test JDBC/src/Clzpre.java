import com.mysql.cj.util.StringInspector;

import java.sql.*;
public class Clzpre {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/prawin";
        String username = "root";
        String password = "prawin";
        String q = "select * from student where name=?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Esatblished!");
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1,"Dipesh");
            ResultSet re = preparedStatement.executeQuery();
            while (re.next()){
                int roll = re.getInt("roll");
                String name = re.getString("name");
                String faculty = re.getString("faculty");
                int marks = re.getInt("marks");
                System.out.println();
                System.out.println("===========================================");
                System.out.println("Roll: "+roll);
                System.out.println("Name: "+name);
                System.out.println("Faculty: "+faculty);
                System.out.println("Marks: "+marks);;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
