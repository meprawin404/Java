public class Excaption1 {

    public static void main(String[] args){
        int balance = 5000;
        int wid_balance = 6000;
        if (balance<wid_balance)
            throw new ArithmeticException("Insuficient blance");

        balance = balance - wid_balance;
        System.out.println("Transaction successful");
        System.out.println("Program countinue");
    }
}
