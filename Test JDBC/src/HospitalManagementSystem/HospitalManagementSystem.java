package HospitalManagementSystem;
import javax.print.Doc;
import java.sql.*;
import java.util.Scanner;


public class HospitalManagementSystem {
    private static final String  url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "prawin";

    public static void main(String [] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection);
            Appointment appointment = new Appointment(connection,scanner);
            while (true){
                System.out.println();
                System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        System.out.println();
                        patient.addPatient();
                        break;

                    case 2:
                        System.out.println();
                        patient.viewPatient();
                        break;

                    case 3:
                        System.out.println();
                        doctor.viewDoctor();
                        break;

                    case 4:
                        System.out.println();
                        appointment.bookAppointment(patient,doctor);
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("THANK YOU FOR USING HOSPITAL MANAGEMENT SYSTEM");
                        return;

                    default:
                        System.out.println();
                        System.out.println("plase Enter valid input");
                        break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}