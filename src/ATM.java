import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);
    public static boolean newTransaction;

    public static void main(String[] args) throws Exception{

        boolean newTransaction = true;

        while(newTransaction){
            Person newPerson = new Person();
            newPerson.enterName();
            newPerson.chooseOption();
            System.out.println("Enter 1 for another transaction or 2 to exit.");
            String answers = scanner.nextLine();
            if(answers.equalsIgnoreCase("2")){
                newTransaction = false;
            }
        }

        System.out.println("Have a nice day!");


    }
}
