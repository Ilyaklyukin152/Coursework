import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private final int id;
    public static int count = 0;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = count;
        count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s, Отдел: %d, Зарплата: %.2f, id: %d", fullName, department, salary, id);
    }
}
