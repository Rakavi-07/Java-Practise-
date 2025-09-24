import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private LocalDate hireDate;
    private boolean active;

    public EmployeeBean() {
    }

    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, LocalDate hireDate, boolean active) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.active = active;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be positive");
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getYearsOfService() {
        if (hireDate == null) return 0;
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(salary);
    }

    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ", 2);
        this.firstName = parts[0];
        this.lastName = parts.length > 1 ? parts[1] : "";
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", yearsOfService=" + getYearsOfService() +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E101");
        emp1.setFullName("Alice Johnson");
        emp1.setSalary(55000);
        emp1.setDepartment("IT");
        emp1.setHireDate(LocalDate.of(2020, 5, 10));
        emp1.setActive(true);

        EmployeeBean emp2 = new EmployeeBean("E102", "Bob", "Smith", 70000,
                "Finance", LocalDate.of(2018, 3, 15), true);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("Years of service for emp2: " + emp2.getYearsOfService());
    }
}
