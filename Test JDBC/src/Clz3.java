import java.sql.*;
public class Clz3 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/prawin";
        String username= "root";
        String password = "prawin";
        String q = "Select count(roll) from student;";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Esatblished!");
            Statement smt = con.createStatement();
            ResultSet re = smt.executeQuery(q);
            re.next();
            int record = re.getInt(1);
            System.out.println(record);



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
