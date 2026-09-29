import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class SmartExpense {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Expense> expenses = new ArrayList<>();
    static double income = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SMART EXPENSE TRACKER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter income: ");
                    income += sc.nextDouble();
                    System.out.println("Income added successfully!");
                    break;

                case 2:
                    System.out.print("Enter expense category: ");
                    String category = sc.next();

                    System.out.print("Enter expense amount: ");
                    double amount = sc.nextDouble();

                    expenses.add(new Expense(category, amount));
                    System.out.println("Expense added successfully!");
                    break;

                case 3:
                    System.out.println("\n----- EXPENSES -----");

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e.category + " : ₹" + e.amount);
                        }
                    }
                    break;

                case 4:
                    double totalExpense = 0;

                    for (Expense e : expenses) {
                        totalExpense += e.amount;
                    }

                    double balance = income - totalExpense;

                    System.out.println("\nTotal Income  : ₹" + income);
                    System.out.println("Total Expense : ₹" + totalExpense);
                    System.out.println("Balance       : ₹" + balance);
                    break;

                case 5:
                    System.out.println("Thank you for using Smart Expense Tracker!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}