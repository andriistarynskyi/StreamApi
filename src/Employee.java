import java.util.Objects;

public class Employee {
    private int id;
    private String fullName;
    private Position position;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String fullName, Position position, int salary) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && fullName.equals(employee.fullName) && position == employee.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, position, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }
}