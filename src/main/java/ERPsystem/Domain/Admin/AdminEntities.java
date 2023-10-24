package ERPsystem.Domain.Admin;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "admin")
@Entity(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AdminEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private String password;

    public AdminEntities(RequestAdminDTO requestAdmin) {
        this.name = requestAdmin.name();
        this.email = requestAdmin.email();
        this.password = requestAdmin.password();

    }

}
