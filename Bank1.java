import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class Real {
    Scanner a = new Scanner(System.in);
    String name, father_name, add;
    String adhar, mobile;
    int balance = 0;
    private final String PASSWORD = "0709";
    Queue<String> transactions = new LinkedList<>();

    boolean isValidAadhaar(String adhar) {
        return adhar.length() == 12 && adhar.matches("\\d+");
    }

    boolean isValidMobile(String mobile) {
        return mobile.length() == 10 && mobile.matches("\\d+");
    }

    void creat() {
        System.out.println("Enter your Name");
        name = a.nextLine();
        System.out.println("Enter Your Father's Name : ");
        father_name = a.nextLine();
        System.out.println("Enter Your ADDRESS : ");
        add = a.nextLine();

        do {
            System.out.println("Enter Your Aadhaar No (12 digits): ");
            adhar = a.next();
            if (!isValidAadhaar(adhar)) {
                System.out.println("Invalid Aadhaar number! Please enter a valid 12-digit Aadhaar.");
            }
        } while (!isValidAadhaar(adhar));

        do {
            System.out.println("Enter your Mobile No (10 digits): ");
            mobile = a.next();
            if (!isValidMobile(mobile)) {
                System.out.println("Invalid mobile number! Please enter a valid 10-digit mobile.");
            }
        } while (!isValidMobile(mobile));

        System.out.println("Your Account has been Successfully Created");
        System.out.println("You can start your transactions in the bank.");
    }

    void display() {
        if (name != null && father_name != null && add != null && adhar != null && mobile != null) {
            System.out.println("....Profile Details ......");
            System.out.println("Name: " + name + " | Father's Name: " + father_name);
            System.out.println("Aadhaar: " + adhar + " | Mobile No: " + mobile);
            System.out.println("Address: " + add);
        } else {
            System.out.println("No data exists for this profile.");
        }
    }

    boolean checkPassword() {
        System.out.println("Enter Password: ");
        String enteredPassword = a.next();
        if (PASSWORD.equals(enteredPassword)) {
            return true;
        } else {
            System.out.println("Incorrect password! Access denied.");
            return false;
        }
    }

    void credit() {
        if (checkPassword()) {
            System.out.println("Enter the amount to deposit: ");
            int newBalance = a.nextInt();
            balance += newBalance;
            transactions.add("Credited: " + newBalance);
            if (transactions.size() > 20) {
                transactions.poll();
            }
            System.out.println(newBalance + " has been deposited successfully.");
        }
    }

    void debit() {
        if (checkPassword()) {
            System.out.println("Enter an amount to withdraw: ");
            int amount = a.nextInt();
            if (amount <= balance) {
                balance -= amount;
                transactions.add("Debited: " + amount);
                if (transactions.size() > 20) {
                    transactions.poll();
                }
                System.out.println(amount + " has been successfully debited from your account.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }

    void balance() {
        if (checkPassword()) {
            System.out.println("Your current balance is: " + balance);
        }
    }

    void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to show.");
        } else {
            System.out.println("Last 20 transactions:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    String getMobile() {
        return mobile;
    }
}

public class Bank1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Real> users = new ArrayList<>();
        int choice;

        do {
            System.out.println("......Banking System......");
            System.out.println("Enter 1 to create an account");
            System.out.println("Enter 2 to display profile");
            System.out.println("Enter 3 to credit an amount");
            System.out.println("Enter 4 to debit an amount");
            System.out.println("Enter 5 to show current balance");
            System.out.println("Enter 6 to show last 20 transactions");
            System.out.println("Enter 7 to exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Real newUser = new Real();
                    newUser.creat();
                    users.add(newUser);
                    break;
                case 2:
                    if (!users.isEmpty()) {
                        System.out.println("Enter the mobile number to display the profile: ");
                        String mobile = sc.next();
                        Real user = findUserByMobile(users, mobile);
                        if (user != null) {
                            user.display();
                        } else {
                            System.out.println("User not found.");
                        }
                    } else {
                        System.out.println("No users available.");
                    }
                    break;
                case 3:
                    if (!users.isEmpty()) {
                        System.out.println("Enter the mobile number for the account: ");
                        String mobile = sc.next();
                        Real user = findUserByMobile(users, mobile);
                        if (user != null) {
                            user.credit();
                        } else {
                            System.out.println("User not found.");
                        }
                    }
                    break;
                case 4:
                    if (!users.isEmpty()) {
                        System.out.println("Enter the mobile number for the account: ");
                        String mobile = sc.next();
                        Real user = findUserByMobile(users, mobile);
                        if (user != null) {
                            user.debit();
                        } else {
                            System.out.println("User not found.");
                        }
                    }
                    break;
                case 5:
                    if (!users.isEmpty()) {
                        System.out.println("Enter the mobile number for the account: ");
                        String mobile = sc.next();
                        Real user = findUserByMobile(users, mobile);
                        if (user != null) {
                            user.balance();
                        } else {
                            System.out.println("User not found.");
                        }
                    }
                    break;
                case 6:
                    if (!users.isEmpty()) {
                        System.out.println("Enter the mobile number for the account: ");
                        String mobile = sc.next();
                        Real user = findUserByMobile(users, mobile);
                        if (user != null) {
                            user.showTransactions();
                        } else {
                            System.out.println("User not found.");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Exiting......");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 7);
    }

    static Real findUserByMobile(List<Real> users, String mobile) {
        for (Real user : users) {
            if (user.getMobile().equals(mobile)) {
                return user;
            }
        }
        return null;
    }
}
