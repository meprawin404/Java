import java.sql.*;
public class Clz2 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/prawin";
        String username= "root";
        String password = "prawin";
        String q = "Select * from student where name='Birat';";

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
