import com.mysql.cj.util.StringInspector;


import java.sql.*;
public class PreStatement {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String q = "select * from employee where name = ?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully!");
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1,"sumit");
            ResultSet re = preparedStatement.executeQuery();
            while (re.next()){
                int id = re.getInt("id");
                String name = re.getString("name");
                String job_title = re.getString("job_title");
                double salary = re.getDouble("salary");
                System.out.println();
                System.out.println("=================================");
                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("job_title: "+job_title);
                System.out.println("salary: "+salary);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
