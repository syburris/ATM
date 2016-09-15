import java.util.ArrayList;

/**
 * Created by stevenburris on 9/14/16.
 */
public class UserName {
    String name;
    String options;
    int withdraw;
    int balance = 100;
    int deposit;
    String answer;
    String answers;
    ArrayList<String> myUserName = new ArrayList<>();



    void enterUserName() throws Exception {
        System.out.println("Please enter your username.");
        name = ATM.scanner.nextLine();
        if(name.isEmpty()){
            throw new Exception("Your username is needed");
        }
        else if(myUserName.contains(name)) {
            System.out.println("Welcome, " + name);
        }
        else{
            System.out.println("You are not a current user.");
            System.lineSeparator();
            addNewUser();
            enterUserName();
        }

    }

    void addNewUser() throws Exception{
        System.out.println("Please enter your new username");
        name = ATM.scanner.nextLine();
        myUserName.add(name);
        System.out.println("Welcome to TIY ATM " + name + "!");
    }

    boolean chooseOption() throws Exception{
        System.out.println("Please enter the number of the operation you would like to perform.");
        System.lineSeparator();
        System.out.println("1: Check Balance");
        System.lineSeparator();
        System.out.println("2: Withdraw Funds");
        System.lineSeparator();
        System.out.println("3: Deposit Funds");
        System.lineSeparator();
        System.out.println("4: Cancel");

        options = ATM.scanner.nextLine();
        if(options.equalsIgnoreCase("1")){
            System.out.println("Your balance is $" + balance);
        }
        else if(options.equalsIgnoreCase("2")){
            System.out.println("How much money would you like to withdraw?");
            withdraw = ATM.scanner.nextInt();
            if(withdraw > balance) {
                throw new Exception("Insufficient Funds");
            }
            else{
                balance = balance - withdraw;
                System.out.println("Please take your $" + withdraw);
                System.lineSeparator();
                System.out.println("Your new balance is $" + balance);
                ATM.scanner.nextLine();

            }
        }
        else if(options.equalsIgnoreCase("3")){
            System.out.println("How much would you like to deposit?");
            deposit = ATM.scanner.nextInt();
            balance = balance + deposit;
            System.out.println("Thank you for your deposit.");
            System.lineSeparator();
            System.out.println("Your new balance is $"+balance);
            ATM.scanner.nextLine();
        }
        else if(options.equalsIgnoreCase("4")){
            cancelTransaction();
            return false;
        }

        else {
            throw new Exception("I'm sorry, your selection is invalid.");
        }
        return true;
    }

    void cancelTransaction(){
        if(options.equalsIgnoreCase("4")){
            System.out.println("Thank you and please come again.");
        }
    }




}
