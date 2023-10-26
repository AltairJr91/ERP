package ERPsystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ERPsystem.Domain.Management.ManagementEntities;
import ERPsystem.Domain.Management.ManagementRepository;

@RestController
@RequestMapping("/management")
public class ManagementController {
    @Autowired
    private ManagementRepository managementRepository;

    @GetMapping
    public ResponseEntity<List<ManagementEntities>> getAllManagement() {
        var allManagement = managementRepository.findAll();
        return ResponseEntity.ok().body(allManagement);
    }
}
// LOCAL PARA Metodos de entradas de mercadorias contas a pagar e a receber via
// caixa da empresa
