package ERPsystem.Domain.Products;

public record RequestProduct(
        String id,
        String name,
        Double value,
        Integer quantity,
        String description,
        String category) {
}