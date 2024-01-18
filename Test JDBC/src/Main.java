import java.sql.*;

public class Main {
    public static void main(String [] args)throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String query = "select * from employee;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established Successfully!");
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery(query);
            while (re.next()){
                int id = re.getInt("id");
                String name = re.getString("name");
                String job_title = re.getString("job_title");
                double salary = re.getDouble("salary");
                System.out.println();
                System.out.println("============================");
                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("job_title: "+job_title);
                System.out.println("salary: "+salary);
            }
            re.close();
            stmt.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}