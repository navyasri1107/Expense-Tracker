 import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;
    String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: $" + amount + ", Description: " + description;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private double total;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        total = 0;
    }

    public void addExpense(String category, double amount, String description) {
        Expense expense = new Expense(category, amount, description);
        expenses.add(expense);
        total += amount;
    }

    public void showExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public void showTotal() {
        System.out.println("Total Expenses: $" + total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();
        
        while (true) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Remove Expenses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // consume the newline character
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    tracker.addExpense(category, amount, description);
                    System.out.println("Expense added!");
                    break;

                case 2:
                    tracker.showExpenses();
                    break;

                case 3:
                    tracker.showTotal();
                    break;

                case 4:
                    System.out.println("Exiting Expense Tracker.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
 
