package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {
    private Connection connection;
    private Scanner scanner;

    public Appointment(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public boolean isDoctorAvailable(int doctor_Id,String appointment_date){
        String query = "SELECT COUNT(*) FROM appointment WHERE id=? and appointment_date=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doctor_Id);
            preparedStatement.setString(2,appointment_date);
            ResultSet re = preparedStatement.executeQuery();
            if (re.next()){
                int count = re.getInt(1);
                if (count == 0){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void bookAppointment(Patient patient,Doctor doctor){
        System.out.println("Enter the Details");
        System.out.println("Enter Patient id");
        int patient_id = scanner.nextInt();
        System.out.println("Enter Doctor id");
        int doctor_id = scanner.nextInt();
        System.out.println("Enter Date YYYY-MM-DD");
        String appoitment_date = scanner.next();

        if(patient.getPatientById(patient_id) && doctor.getDoctorById(doctor_id)){
            if (isDoctorAvailable(doctor_id, appoitment_date)) {
                String query = "INSERT INTO appointment(patient_id,doctor_id,appointment_date) VALUES (?,?,?);";
                try {
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1,patient_id);
                        preparedStatement.setInt(2,doctor_id);
                        preparedStatement.setString(3,appoitment_date);
                        int effect = preparedStatement.executeUpdate();
                        if (effect>0){
                            System.out.println("Appoitment Date Booked");
                        }else {
                            System.out.println("Failed to Book");
                        }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Doctor not availabel on this date!");
            }
        }else {
            System.out.println("Either Doctor or Patient not exists!");
        }
    }
}