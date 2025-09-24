import java.util.Scanner;

class Employee {
    // Static variables
    private static String companyName;
    private static int totalEmployees = 0;

    // Instance variables
    private String empId;
    private String name;
    private String department;
    private double salary;

    // Default constructor
    public Employee() {
        this.empId = "";
        this.name = "";
        this.department = "";
        this.salary = 0.0;
        totalEmployees++;
    }

    // Parameterized constructor
    public Employee(String empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++;
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    // Instance methods
    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void displayEmployee() {
        System.out.println("[" + department + "] " + empId + " - " + name + " | Salary: " + salary);
    }

    // Getters
    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

// ================= Department Class =================
class Department {
    private String deptName;
    private Employee[] employees;
    private int employeeCount;

    public Department(String deptName, int capacity) {
        this.deptName = deptName;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }

    public String getDeptName() {
        return deptName;
    }

    public void addEmployee(Employee e) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = e;
            System.out.println("Employee added to " + deptName + " successfully.");
        } else {
            System.out.println("Department is full!");
        }
    }

    public void displayAllEmployees() {
        System.out.println("=== Employees in Department: " + deptName + " ===");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployee();
        }
    }

    public Employee findHighestPaid() {
        if (employeeCount == 0) return null;
        Employee highest = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > highest.getSalary()) {
                highest = employees[i];
            }
        }
        return highest;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public Employee searchEmployee(String empId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmpId().equals(empId)) {
                return employees[i];
            }
        }
        return null;
    }
}

// ================= Main Application =================
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");
        System.out.print("Enter Company Name: ");
        String cname = scanner.nextLine();
        Employee.setCompanyName(cname);

        // Create Departments
        Department hr = new Department("HR", 10);
        Department it = new Department("IT", 10);
        Department sales = new Department("Sales", 10);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Department Statistics");
            System.out.println("5. Company Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department (HR/IT/Sales): ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    Employee emp = new Employee(id, name, dept, salary);
                    if (dept.equalsIgnoreCase("HR")) {
                        hr.addEmployee(emp);
                    } else if (dept.equalsIgnoreCase("IT")) {
                        it.addEmployee(emp);
                    } else if (dept.equalsIgnoreCase("Sales")) {
                        sales.addEmployee(emp);
                    } else {
                        System.out.println("Invalid Department!");
                    }
                    break;

                case 2:
                    hr.displayAllEmployees();
                    it.displayAllEmployees();
                    sales.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee found = hr.searchEmployee(searchId);
                    if (found == null) found = it.searchEmployee(searchId);
                    if (found == null) found = sales.searchEmployee(searchId);

                    if (found != null) {
                        found.displayEmployee();
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4:
                    System.out.println("HR Payroll: " + hr.calculateTotalPayroll());
                    System.out.println("IT Payroll: " + it.calculateTotalPayroll());
                    System.out.println("Sales Payroll: " + sales.calculateTotalPayroll());

                    Employee topHR = hr.findHighestPaid();
                    Employee topIT = it.findHighestPaid();
                    Employee topSales = sales.findHighestPaid();

                    Employee highestPaid = topHR;
                    if (topIT != null && (highestPaid == null || topIT.getSalary() > highestPaid.getSalary())) {
                        highestPaid = topIT;
                    }
                    if (topSales != null && (highestPaid == null || topSales.getSalary() > highestPaid.getSalary())) {
                        highestPaid = topSales;
                    }

                    if (highestPaid != null) {
                        System.out.println("Highest Paid Employee: ");
                        highestPaid.displayEmployee();
                    } else {
                        System.out.println("No employees yet.");
                    }
                    break;

                case 5:
                    double totalPayroll = hr.calculateTotalPayroll() + it.calculateTotalPayroll() + sales.calculateTotalPayroll();
                    System.out.println("Company Name: " + Employee.getCompanyName());
                    System.out.println("Total Employees: " + Employee.getTotalEmployees());
                    System.out.println("Total Company Payroll: " + totalPayroll);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

