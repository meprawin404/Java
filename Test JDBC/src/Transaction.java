import java.sql.*;
public class Transaction {
    public static void main(String [] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prawin";
        String withdrawalQuery = "UPDATE account SET balance = balance - ? WHERE account_number = ?;";
        String DepositeQuery = "UPDATE account SET balance = balance + ? WHERE account_number = ?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established!");
            con.setAutoCommit(false);
            try {
                PreparedStatement withdrawal = con.prepareStatement(withdrawalQuery);
                PreparedStatement deposite = con.prepareStatement(DepositeQuery);
                withdrawal.setDouble(1,500);
                withdrawal.setString(2,"account123");
                deposite.setDouble(1,500);
                deposite.setString(2,"account10");
                int effectwithdrawal = withdrawal.executeUpdate();
                int effectdeposite = deposite.executeUpdate();
                if (effectwithdrawal>0 && effectdeposite>0){
                    System.out.println("Transaction successFull!");
                    con.commit();
                }else {
                    System.out.println("Transaction failed");
                    con.rollback();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
