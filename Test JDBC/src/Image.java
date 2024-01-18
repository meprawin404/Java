import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class Image {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String img_path = "C:\\Users\\sudhi\\Downloads\\tree-736885_1920.jpg";
        String query = "INSERT INTO img_table(img_data) values (?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established!");
            FileInputStream fileInputStream = new FileInputStream(img_path);
            byte[] img_data = new byte[fileInputStream.available()];
            fileInputStream.read(img_data);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setBytes(1,img_data);
            int effect = preparedStatement.executeUpdate();
            if (effect>0){
                System.out.println("Data inserted");
            }else {
                System.out.println("Failed to insert");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}