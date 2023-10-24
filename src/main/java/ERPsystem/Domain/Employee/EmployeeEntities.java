package ERPsystem.Domain.Employee;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "employees")
@Entity(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EmployeeEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String jobrole;
    private Float salary;

    public EmployeeEntities(RequestEmployeeDTO requestEmployee) {
        this.name = requestEmployee.name();
        this.jobrole = requestEmployee.jobrole();
        this.salary = requestEmployee.salary();

    }

}
