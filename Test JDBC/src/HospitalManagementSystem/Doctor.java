package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection){
        this.connection = connection;
    }

    public void viewDoctor(){
        String query = "SELECT * FROM DOCTOR;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet re = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| Doctor Id  | Name               | Specialization   |");
            System.out.println("+------------+--------------------+------------------+");
            while (re.next()){
                int id = re.getInt("id");
                String name = re.getString("name");
                String specialization = re.getString("specialization");
                System.out.printf("| %-10s | %-18s | %-16s |\n", id, name, specialization);
                System.out.println("+------------+--------------------+------------------+");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id){
        String query = "SELECT * FROM DOCTOR WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet re = preparedStatement.executeQuery();
            if (re.next()){
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}