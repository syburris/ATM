import java.util.*;


/**
 * Created by stevenburris on 9/14/16.
 */
public class User {
    String name;
    String options;
    String password;
    int withdraw;
    int balance = (Integer) ATM.users.get("balance");
    int deposit;

    //log in method
    void logIn() throws Exception {
        System.out.println("Please enter your username.");
        name = ATM.scanner.nextLine();
        if(name.isEmpty()) {
            throw new Exception("Your username is needed");
        }
        else if(ATM.users.containsValue(name)) {
            System.out.println("Welcome, " + name);
            System.lineSeparator();
            System.out.println("Please enter your password.");
            checkPassword();
        }
        else {
            System.out.println("You are not a current user.");
            System.lineSeparator();
            addNewUser();
            logIn();
        }

    }
    //adds new user to the users HashMap
    void addNewUser() throws Exception {
        System.out.println("Please enter your desired username");
        name = ATM.scanner.nextLine();
        ATM.users.put("username",name);
        ATM.users.put("balance",100);
        System.out.println("Welcome to TIY ATM " + name + "!");
        addPassword();
    }
    //adds new user's password to the users HashMap
    void addPassword() throws Exception {
        System.out.println("What would you like your password to be?");
        password = ATM.scanner.nextLine();
        if(password.isEmpty()) {
            throw new Exception("You must enter a password.");
        }
        ATM.users.put("password",password);
        System.out.println("Thanks for choosing a password!");
        System.lineSeparator();
        System.out.println("Now please log in.");
    }
    //verify that password entered is correct
    void checkPassword() throws Exception {
        if(ATM.scanner.nextLine().equals(ATM.users.get("password"))) {
            chooseOption();
        }
        else{
            throw new Exception("Sorry, your password is incorrect.");
        }

    }

    boolean chooseOption() throws Exception {
        System.out.println("Please enter the number of the operation you would like to perform.");
        System.lineSeparator();
        System.out.println("1: Check Balance");
        System.lineSeparator();
        System.out.println("2: Withdraw Funds");
        System.lineSeparator();
        System.out.println("3: Deposit Funds");
        System.lineSeparator();
        System.out.println("4: Log Out");
        System.lineSeparator();
        System.out.println("5: Close Account");

        options = ATM.scanner.nextLine();
        if(options.equals("1")){
            System.out.println("Your balance is $" + ATM.users.get("balance"));
        }
        else if (options.equals("2")) {
            System.out.println("How much money would you like to withdraw?");
            withdraw = ATM.scanner.nextInt();
            if (withdraw > (Integer) ATM.users.get("balance")) {
                throw new Exception("Insufficient Funds");
            } else {
                balance = balance - withdraw;
                ATM.users.put("balance", balance);
                System.out.println("Please take your $" + withdraw);
                System.lineSeparator();
                System.out.println("Your new balance is $" + balance);
                ATM.scanner.nextLine();
            }
        }
        else if (options.equals("3")) {
            System.out.println("How much would you like to deposit?");
            deposit = ATM.scanner.nextInt();
            balance = (Integer) ATM.users.get("balance") + deposit;
            ATM.users.put("balance", balance);
            System.out.println("Thank you for your deposit.");
            System.lineSeparator();
            System.out.println("Your new balance is $" + ATM.users.get("balance"));
            ATM.scanner.nextLine();
        }
        else if (options.equals("4")) {
            logOut();
            return false;
        }
        else if (options.equals("5")) {
            System.out.println("We're sorry you have decided to close your account.");
            System.lineSeparator();
            System.out.println("Here is your $" + ATM.users.get("balance"));
            removeAccount();
            System.exit(0);
        }
        else {
            throw new Exception("I'm sorry, your selection is invalid.");
        }

        return true;
    }

    void logOut() throws Exception {
        if(options.equals("4")){
            System.out.println("Thank you and please come again.");
            logIn();
        }
    }

    void removeAccount() {
        ATM.users.clear();
    }




}
