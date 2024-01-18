import java.sql.*;
public class Main3 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String query = "DELETE FROM employee WHERE id=1;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
            int effect = stmt.executeUpdate(query);
            if (effect>0){
                System.out.println("successfully deleted "+effect+" row");
            }else {
                System.out.println("failed to delete");
            }

            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
