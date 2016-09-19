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

//        users.put("userName", "Steven");
//        users.put("password","1234");
//        users.put("balance", 100);
        User user = new User();
        user.name = "steven";
        user.password = "1234";
        user.balance = 100;
        users.put(user.name, user);
        System.out.println(users.get(user.name));


        User newUser = new User();

        newUser.logIn();

        while (newTransaction) {
            newTransaction = newUser.chooseOption();
            if(newTransaction) {
                System.out.println("Enter 1 for another transaction, 2 to exit, or 3 to log out.");
                String answer = scanner2.nextLine();
                if (answer.equals("1")) {
                    newUser.chooseOption();
                }
                else if(answer.equalsIgnoreCase("2")) {
                    newTransaction = false;
                }
                else if(answer.equals("3")){
                        newUser.logOut();
                }

            }

        }
        System.out.println("Have a nice day!");
        System.lineSeparator();
        System.lineSeparator();


    }
}