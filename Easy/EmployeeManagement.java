import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added.");
    }

    public static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.print("Enter new Name: ");
                e.setName(scanner.nextLine());
                System.out.print("Enter new Salary: ");
                e.setSalary(scanner.nextDouble());
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.getId() == id);
        System.out.println("Employee removed.");
    }

    public static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add 2. Update 3. Remove 4. Search 5. Display 0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: updateEmployee(); break;
                case 3: removeEmployee(); break;
                case 4: searchEmployee(); break;
                case 5: displayAll(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
