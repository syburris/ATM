import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    public static boolean newTransaction = true;

    public static void main(String[] args) throws Exception {

        String answers;

        UserName newUserName = new UserName();
        newUserName.enterName();

        while (newTransaction) {

            newTransaction = newUserName.chooseOption();
            if(newTransaction) {
                System.out.println("Enter 1 for another transaction or 2 to exit.");
                String answer = scanner2.next();
                if (answer.equalsIgnoreCase("2")) {
                    newTransaction = false;
                }
            }

        }
        System.out.println("Have a nice day!");

    }
}