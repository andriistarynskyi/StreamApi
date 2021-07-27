import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    private static List<Employee> getAllEmployees() {
        return List.of(
                new Employee(1, "Peter Alex", Position.DEV_OPS, 10000),
                new Employee(2, "Alex Jenkins", Position.MANAGER, 12000),
                new Employee(3, "Brinna Smith", Position.ENGINEER, 8000),
                new Employee(4, "Vladimir Jenkins", Position.ENGINEER, 7000),
                new Employee(5, "Maria Smith", Position.ENGINEER, 7500)
        );
    }

    public static void executeApp() {
        List<Employee> employees = getAllEmployees();

        filterBySpeciality(employees, Position.MANAGER).forEach(System.out::println);
        sortEmployeesByFullNameAsc(employees).forEach(System.out::println);
        sortEmployeesByFullNameDesc(employees).forEach(System.out::println);
        System.out.println(getEmployeeWithMaxSalary(employees));
        System.out.println(getEmployeeWithMinSalary(employees));
        System.out.println(mapByPosition(employees));
        System.out.println(matchAllEngineers(employees));
        System.out.println(anyDevOps(employees));
    }

    private static List<Employee> filterBySpeciality(List<Employee> employees, Position position) {
        return employees.stream()
                .filter(employee -> employee.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    private static List<Employee> sortEmployeesByFullNameAsc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFullName))
                .collect(Collectors.toList());
    }

    private static List<Employee> sortEmployeesByFullNameDesc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFullName).reversed())
                .collect(Collectors.toList());
    }

    private static Employee getEmployeeWithMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    private static Employee getEmployeeWithMinSalary(List<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    private static Map<Position, List<Employee>> mapByPosition(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getPosition));
    }

    private static boolean matchAllEngineers(List<Employee> employees) {
        return employees.stream()
                .allMatch(employee -> employee.getPosition().equals(Position.ENGINEER));
    }

    private static boolean anyDevOps(List<Employee> employees) {
        return employees.stream().anyMatch(employee -> employee.getPosition().equals(Position.DEV_OPS));
    }
}