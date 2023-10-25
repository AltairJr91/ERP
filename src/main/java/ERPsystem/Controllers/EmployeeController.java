package ERPsystem.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import ERPsystem.Domain.Employee.*;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<EmployeeEntities> storeEmploy(@RequestBody RequestEmployeeDTO data) {
        EmployeeEntities employee = new EmployeeEntities(data);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntities>> getAllEmployees(@RequestBody RequestEmployeeDTO data) {
        var allEmployess = employeeRepository.findAll();
        return ResponseEntity.ok().body(allEmployess);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<EmployeeEntities>> getEmployee(@RequestBody RequestEmployeeDTO data) {
        // precisa de testes para validar funcionamento 
        var employe = employeeRepository.findById(data.id());
        return ResponseEntity.ok().body(employe);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<String> updateEmployee(@RequestBody RequestEmployeeDTO data) {
        Optional<EmployeeEntities> optionalemployee = employeeRepository.findById(data.id());
        if (optionalemployee.isPresent()) {
            EmployeeEntities employee = optionalemployee.get();
            employee.setName(data.name());
            employee.setSalary(data.salary());
            employee.setJobrole(data.jobrole());

            return ResponseEntity.ok().body("Employee updated with success");
        } else {
            return ((BodyBuilder) ResponseEntity.notFound()).body("error");
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable RequestEmployeeDTO data) {
        employeeRepository.deleteById(data.id());
        return ResponseEntity.ok().body("Employee deleted with success");
    }

}
