import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    public static boolean newTransaction = true;
    public static HashMap<String, Object> users = new HashMap<>();
    public static ArrayList<Integer> userBalance = new ArrayList<Integer>();


    public static void main(String[] args) throws Exception {

        userBalance.add(0,100);

        users.put("userName", "Steven");
        users.put("password","1234");
        users.put("balance", userBalance.get(0));


        Person newPerson = new Person();
        newPerson.logIn();

        while (newTransaction) {

            newTransaction = newPerson.chooseOption();
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