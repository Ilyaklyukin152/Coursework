public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иван Иванович", 1, 100000);
        employees[1] = new Employee("Сидоров Андрей Петрович", 3, 150000);
        employees[2] = new Employee("Казаков Александр Михайлович", 5, 70000);
        employees[3] = new Employee("Орехова Алиса Львовна", 2, 65000);
        employees[4] = new Employee("Гладков Семён Артёмович", 1, 98000);
        employees[5] = new Employee("Чеснокова Мария Владимировна", 3, 210000);
        employees[6] = new Employee("Софронов Кирилл Давидович", 4, 143000);
        employees[7] = new Employee("Шмелев Алексей Александрович", 4, 56000);
        employees[8] = new Employee("Суворова Софья Григорьевна", 3, 85000);
        employees[9] = new Employee("Сизов Артём Максимович", 5, 43000);

        System.out.println();
        printAllEmployees();
        System.out.println();
        System.out.printf("Сумма затрат на ЗП в месяц: %.2f\n", calculateTotalSalary());
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeMinSalary());
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeMaxSalary());
        System.out.println();
        System.out.printf("Среднее значение зарплат: %.2f\n", calculateAvgSalary());
        System.out.println();
        printNamesAllEmployee();
        System.out.println();
        indexSalary(10);
        System.out.println();
        printAllEmployees();
        System.out.println();
        indexSalaryDepartment(3, 15);
        System.out.println();
        System.out.println(findEmployeeMinSalaryDepartment(3));
        System.out.println();
        System.out.println(findEmployeeMaxSalaryDepartment(5));
        System.out.println();
        System.out.printf("Сумма затрат на ЗП в месяц по отделу: %.2f\n", calculateTotalSalaryDepartment(4));
        System.out.println();
        System.out.printf("Среднее значение зарплат по отделу: %.2f\n", calculateAvgSalaryDepartment(1));
        System.out.println();
        printAllEmployeeDepartment(4);
        System.out.println();
        printEmployeeSalaryLess(70000);
        System.out.println();
        printEmployeeSalaryMore(150000);
    }

    public static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double calculateTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    public static Employee findEmployeeMinSalary() {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAvgSalary() {
        return calculateTotalSalary() / Employee.count;
    }

    public static void printNamesAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static void indexSalary(double percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() * (1 + percent / 100));
        }
    }

    public static Employee findEmployeeMinSalaryDepartment(int department) {
        Employee minSalaryDepartment = null;
        for (Employee employee : employees) {
            if (department == employee.getDepartment() && (minSalaryDepartment == null || minSalaryDepartment.getSalary() > employee.getSalary())) {
                minSalaryDepartment = employee;
            }
        }

        return minSalaryDepartment;
    }

    public static Employee findEmployeeMaxSalaryDepartment(int department) {
        Employee maxSalaryDepartment = null;
        for (Employee employee : employees) {
            if (department == employee.getDepartment() && (maxSalaryDepartment == null || maxSalaryDepartment.getSalary() < employee.getSalary())) {
                maxSalaryDepartment = employee;
            }
        }

        return maxSalaryDepartment;
    }

    public static double calculateTotalSalaryDepartment(int department) {
        double total = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static double calculateAvgSalaryDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                count++;
            }
        }
        return calculateTotalSalaryDepartment(department) / count;
    }

    public static void indexSalaryDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
            }
        }
    }

    public static void printAllEmployeeDepartment(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.printf("ФИО: %s, Зарплата: %.2f, id: %d\n", employee.getFullName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public static void printEmployeeSalaryLess(double value) {
        for (Employee employee : employees) {
            if (value > employee.getSalary()) {
                System.out.printf("Id: %d, ФИО: %s, Зарплата: %.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printEmployeeSalaryMore(double value) {
        for (Employee employee : employees) {
            if (value <= employee.getSalary()) {
                System.out.printf("Id: %d, ФИО: %s, Зарплата: %.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }
}