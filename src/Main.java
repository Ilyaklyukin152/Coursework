public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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
        printAllEmployees(employees);
        System.out.println();
        System.out.printf("Сумма затрат на ЗП в месяц: %.2f\n", calculateTotalSalary(employees));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeMinSalary(employees));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeMaxSalary(employees));
        System.out.println();
        System.out.printf("Среднее значение зарплат: %.2f\n", calculateAvgSalary(employees));
        System.out.println();
        printNamesAllEmployee(employees);
        System.out.println();
        indexSalary(employees, 10);
        System.out.println();
        printAllEmployees(employees);
        System.out.println();
        indexSalaryDepartment(employees, 3, 15);
        System.out.println();
        System.out.println(findEmployeeMinSalaryDepartment(employees, 3));
        System.out.println();
        System.out.println(findEmployeeMaxSalaryDepartment(employees, 5));
        System.out.println();
        System.out.printf("Сумма затрат на ЗП в месяц по отделу: %.2f\n", calculateTotalSalaryDepartment(employees, 4));
        System.out.println();
        System.out.printf("Среднее значение зарплат по отделу: %.2f\n", calculateAvgSalaryDepartment(employees, 1));
        System.out.println();
        printAllEmployeeDepartment(employees, 4);
        System.out.println();
        printEmployeeSalaryLess(employees, 70000);
        System.out.println();
        printEmployeeSalaryMore(employees, 150000);
    }

    public static void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double calculateTotalSalary(Employee[] employees) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    public static Employee findEmployeeMinSalary(Employee[] employees) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAvgSalary(Employee[] employees) {
        return calculateTotalSalary(employees) / Employee.count;
    }

    public static void printNamesAllEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static void indexSalary(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() * (1 + percent / 100));
        }
    }

    public static Employee findEmployeeMinSalaryDepartment(Employee[] employees, int department) {
        Employee minSalaryDepartment = null;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                if (minSalaryDepartment == null || minSalaryDepartment.getSalary() > employee.getSalary()) {
                    minSalaryDepartment = employee;
                }
            }
        }
        return minSalaryDepartment;
    }

    public static Employee findEmployeeMaxSalaryDepartment(Employee[] employees, int department) {
        Employee maxSalaryDepartment = null;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                if (maxSalaryDepartment == null || maxSalaryDepartment.getSalary() < employee.getSalary()) {
                    maxSalaryDepartment = employee;
                }
            }
        }
        return maxSalaryDepartment;
    }

    public static double calculateTotalSalaryDepartment(Employee[] employees, int department) {
        double total = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static double calculateAvgSalaryDepartment(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                count++;
            }
        }
        return calculateTotalSalaryDepartment(employees, department) / count;
    }

    public static void indexSalaryDepartment(Employee[] employees, int department, double percent) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() * (1 + percent / 100));
            }
        }
    }

    public static void printAllEmployeeDepartment(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.printf("ФИО: %s, Зарплата: %.2f, id: %d\n", employee.getFullName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public static void printEmployeeSalaryLess(Employee[] employees, double value) {
        for (Employee employee : employees) {
            if (value > employee.getSalary()) {
                System.out.printf("Id: %d, ФИО: %s, Зарплата: %.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printEmployeeSalaryMore(Employee[] employees, double value) {
        for (Employee employee : employees) {
            if (value <= employee.getSalary()) {
                System.out.printf("Id: %d, ФИО: %s, Зарплата: %.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }
}