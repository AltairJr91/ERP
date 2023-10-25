package ERPsystem.Domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntities, String> {

    void setName(String name);

    void setSalary(Float salary);

    void setJobRole(String jobrole);
}