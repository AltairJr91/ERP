package ERPsystem.Domain.Products;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntities {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Double value;
    private Integer quantity;
    private String description;
    private String category;

    public ProductEntities(RequestProductDTO requestProduct){
        this.name = requestProduct.name();
        this.value = requestProduct.value();
        this.quantity = requestProduct.quantity();
        this.description = requestProduct.description();
        this.category = requestProduct.category();
    }

}
