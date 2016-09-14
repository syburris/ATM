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
            String answers = scanner.nextLine();
            if(answers.equalsIgnoreCase("y")){
                newTransaction = false;
            }
        }

        System.out.println("Have a nice day!");


    }
}
