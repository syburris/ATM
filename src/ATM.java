import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception{

        boolean newTransaction = true;
        String answer;

        while(newTransaction){
            Person newPerson = new Person();
            newPerson.enterName();
            newPerson.chooseOption();
            System.out.println("Would you like to make another transaction?");
            System.out.println("Type 1 to make another transaction or 2 to exit.");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("2")){
                newTransaction = false;
            }
            else if(answer.equalsIgnoreCase("1")){
                newPerson.chooseOption();
            }

        }
        System.out.println("Have a nice day!");


    }
}
