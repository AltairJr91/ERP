package ERPsystem.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ERPsystem.Domain.Products.ProductEntities;
import ERPsystem.Domain.Products.ProductRepository;
import ERPsystem.Domain.Products.RequestProductDTO;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductEntities>> getAllProducts() {
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok().body(allProducts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ProductEntities>> getProduct(@RequestBody RequestProductDTO data) {
        Optional<ProductEntities> product = productRepository.findById(data.id());
        if (product.isPresent()) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping
    public ResponseEntity<ProductEntities> storeProduct(@RequestBody RequestProductDTO data) {
        ProductEntities product = new ProductEntities(data);
        productRepository.save(product);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProductEntities> updateProduct(@RequestBody RequestProductDTO data) {
        Optional<ProductEntities> optionalproduct = productRepository.findById(data.id());
        if (optionalproduct.isPresent()) {
            ProductEntities products = optionalproduct.get();
            products.setName(data.name());
            products.setCategory(data.category());
            products.setValue(data.value());
            products.setDescription(data.description());
            products.setQuantity(data.quantity());

            return ResponseEntity.created(null).body(products);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable RequestProductDTO data) {
        productRepository.deleteById(data.id());
        return ResponseEntity.ok().body("Product deleted with success");
    }

}

// controle de produtos quantidade valor e tipos de produtos
