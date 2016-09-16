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
    //asks the user to enter their username

    //
    void logIn() throws Exception {
        System.out.println("Please enter your username.");
        name = ATM.scanner.nextLine();

        //throw exception and exit's program
        //if user doesn't enter anything for username

        if(name.isEmpty()) {
            throw new Exception("Your username is needed");
        }

        //if username is recognized, print Welcome user
        //then run checkPassword method

        else if(ATM.users.containsValue(name)) {
            System.out.println("Welcome, " + name);
            System.lineSeparator();
            System.out.println("Please enter your password.");
            checkPassword();
        }

        //if the username is not recognized
        //and print out that they are not a current user
        //then run then addNewUser method
        else {
            System.out.println("You are not a current user.");
            System.lineSeparator();
            addNewUser();
        }

    }

    //asks new user what they want their username to be
    //adds new user to the users HashMap
    //automatically sets their initial balance to $100
    //prints out welcome "entered username" and then
    //calls the add password method

    void addNewUser() throws Exception {
        System.out.println("Please enter your desired username");
        name = ATM.scanner.nextLine();
        ATM.users.put("username",name);
        ATM.users.put("balance",100);
        System.out.println("Welcome to TIY ATM " + name + "!");
        addPassword();
    }

    //asks the user what they want their password to be,
    //then adds new user's password to the users HashMap

    void addPassword() throws Exception {
        System.out.println("What would you like your password to be?");
        password = ATM.scanner.nextLine();

        //if the password is empty, throw exception and exit program

        if(password.isEmpty()) {
            throw new Exception("You must enter a password.");
        }

        //print out
        ATM.users.put("password",password);
        System.out.println("Thanks for choosing a password!");
        System.lineSeparator();
        System.out.println("Now please log in.");
        logIn();
    }

    // method made to verify that password entered is correct
    //if the user's password is correct, run chooseOption method
    //if the user's password is incorrect, throw exception and exit program

    void checkPassword() throws Exception {
        if(!ATM.scanner.nextLine().equals(ATM.users.get("password"))) {
            throw new Exception("Sorry, your password is incorrect.");
        }

    }
        //prints out the 5 options the user can choose

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

        //scanner object to allow user to choose option 1-5
        options = ATM.scanner.nextLine();

        //if user chooses option 1, print out their balance
        if(options.equals("1")){
            System.out.println("Your balance is $" + ATM.users.get("balance"));
        }

        //if user chooses option 2, enter the amount they want to withdraw
        //and then print out new balance

        else if (options.equals("2")) {
            System.out.println("How much money would you like to withdraw?");
            withdraw = ATM.scanner.nextInt();

            //if the withdraw amount is larger than the balance,
            //then throw error that the user has insufficient funds

            if (withdraw > (Integer) ATM.users.get("balance")) {
                throw new Exception("Insufficient Funds");
            }
            //updates the balance and tells the user
            //to take their money, then prints new balance

            else {
                balance = balance - withdraw;
                ATM.users.put("balance", balance);
                System.out.println("Please take your $" + withdraw);
                System.lineSeparator();
                System.out.println("Your new balance is $" + balance);
                ATM.scanner.nextLine();
            }
        }

        //if you choose option 3, make a deposit and return new balance

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

        // if you choose option 4, run method logOut to allow new user to log in

        else if (options.equals("4")) {
            logOut();
            return false;
        }

        //if you choose option 5 to remove account

        else if (options.equals("5")) {
            System.out.println("We're sorry you have decided to close your account.");
            System.lineSeparator();
            System.out.println("Here is your $" + ATM.users.get("balance"));
            removeAccount();
            System.exit(0);
        }

        //if you don't enter 1-5, throw an error message and exit system

        else {
            throw new Exception("I'm sorry, your selection is invalid.");
        }
        return true;
    }

    // method made to log out so another user can log in
    void logOut() throws Exception {
        if(options.equals("4")){
            System.out.println("Thank you and please come again.");
            logIn();
        }
    }

    //method to remove the user's account

    void removeAccount() {
        ATM.users.clear();
    }




}
