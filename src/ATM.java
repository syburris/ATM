import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    public static boolean newTransaction = true;
    public static HashMap<String, Object> users = new HashMap<>();


    public static void main(String[] args) throws Exception {

        users.put("userName", "Steven");
        users.put("password","1234");
        users.put("balance", 100);


        User newUser = new User();

        while (newTransaction) {

            newUser.logIn();
            newTransaction = newUser.chooseOption();
            if(newTransaction) {
                System.out.println("Enter 1 for another transaction, 2 to exit, or 3 to log out.");
                String answer = scanner2.next();
                if (answer.equals("1")) {
                    newUser.chooseOption();
                }
                if (answer.equalsIgnoreCase("2")) {
                    newTransaction = false;
                }
                else {
                        newTransaction = true;
                }
            }

        }
        System.out.println("Have a nice day!");
        System.lineSeparator();
        System.lineSeparator();


    }
}