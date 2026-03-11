import java.util.*;

class Expense {
    int id;
    String category;
    double amount;
    String date;

    Expense(int id, String category, double amount, String date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Category: " + category +
                " | Amount: " + amount +
                " | Date: " + date);
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n------ Expense Tracker ------");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total Expense");
            System.out.println("4. Category Summary");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    showTotal();
                    break;

                case 4:
                    categorySummary();
                    break;

                case 5:
                    deleteExpense();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void addExpense() {

        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = sc.next();

        expenses.add(new Expense(id, category, amount, date));

        System.out.println("Expense Added Successfully");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }

        for (Expense e : expenses) {
            e.display();
        }
    }

    static void showTotal() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total Expense: " + total);
    }

    static void categorySummary() {

        HashMap<String, Double> summary = new HashMap<>();

        for (Expense e : expenses) {
            summary.put(e.category,
                    summary.getOrDefault(e.category, 0.0) + e.amount);
        }

        System.out.println("Category Wise Expense:");

        for (String category : summary.keySet()) {
            System.out.println(category + " : " + summary.get(category));
        }
    }

    static void deleteExpense() {

        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();

        boolean removed = expenses.removeIf(e -> e.id == id);

        if (removed) {
            System.out.println("Expense Deleted");
        } else {
            System.out.println("Expense not found");
        }
    }
}