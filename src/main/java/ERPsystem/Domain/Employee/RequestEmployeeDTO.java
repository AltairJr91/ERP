package ERPsystem.Domain.Employee;

public record RequestEmployeeDTO(
        String id,
        String name,
        String jobrole,
        Float salary) {
}
