public class Excaption2 {
    public static void main(String[] args){
        int balance = 5000;
        int wid_balance = 6000;
        try {
            if (balance<wid_balance)
                throw new ArithmeticException("Insificent balance");
            balance = balance - wid_balance;
            System.out.println("Transcation compeleted successfully");
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Program continue");
    }
}
