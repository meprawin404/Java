import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
public class Image2 {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String folder_path = "C:\\Users\\sudhi\\Pictures\\Saved Pictures\\";
        String query = "select img_data from img_table where img_id = (?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet re = preparedStatement.executeQuery();
            if (re.next()){
                byte[] img_data = re.getBytes("img_data");
                String img_path = folder_path+"Extracted img";
                FileOutputStream fileOutputStream = new FileOutputStream(img_path);
                fileOutputStream.write(img_data);
            }else {
                System.out.println("can't extract");
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
