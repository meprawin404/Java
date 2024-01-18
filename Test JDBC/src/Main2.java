import java.sql.*;
public class Main2 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String query = "INSERT INTO employee(id,name,job_title,salary) VALUES (3,'sanjip','BBA',55000);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement smt = con.createStatement();
            int effect = smt.executeUpdate(query);

            if(effect>0){
                System.out.println("Inserted successfully "+effect+" row effected");
            }
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
