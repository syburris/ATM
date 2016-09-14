import java.util.*;

/**
 * Created by stevenburris on 9/14/16.
 */
public class ATM {


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception{

        String name;

        System.out.println("Please enter your name.");
        name = ATM.scanner.nextLine();
        if(name.isEmpty()){
            throw new Exception("Your name is needed");
        }
        System.out.println("Welcome, "+ name);




    }
}
