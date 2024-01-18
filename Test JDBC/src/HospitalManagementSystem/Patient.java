package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient(){
        System.out.println("Enter patient details");
        System.out.println("Enter name of patient");
        String name = scanner.next();
        System.out.println("Enter age");
        int age = scanner.nextInt();
        System.out.println("Enter gender");
        String gender = scanner.next();

        try {
            String query = "INSERT INTO PATIENT(name,age,gender) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            int effect = preparedStatement.executeUpdate();
            if (effect>0) {
                System.out.println("Patient Added");
            }else {
                System.out.println("Failed to add Patient");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewPatient(){
        String query = "SELECT * FROM PATIENT;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet re = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while (re.next()){
                int id = re.getInt("id");
                String name = re.getString("name");
                int age = re.getInt("age");
                String gender = re.getString("gender");
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getPatientById(int id){
        String query = "SELECT * FROM PATIENT WHERE id = ?;";
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