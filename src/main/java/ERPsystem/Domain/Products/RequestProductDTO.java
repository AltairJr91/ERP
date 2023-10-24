package ERPsystem.Domain.Products;

public record RequestProductDTO(
        String id,
        String name,
        Double value,
        Integer quantity,
        String description,
        String category) {
}