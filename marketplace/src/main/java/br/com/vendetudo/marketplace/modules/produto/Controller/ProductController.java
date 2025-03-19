package br.com.vendetudo.marketplace.modules.produto.Controller;

import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Service.ProductService;
import br.com.vendetudo.marketplace.modules.produto.Service.ProductServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("produtos")
@RestController
public class ProductController {

private final ProductServiceImplement productServiceImplement;
    @Autowired
    public ProductController(ProductServiceImplement productServiceImplement) {
        this.productServiceImplement = productServiceImplement;
    }

    @PatchMapping("/{id}/addQuantity")
    public ResponseEntity<Void> addQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        productServiceImplement.addProductQuantity(id, quantity);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{brand}")
    public Map<Long, ProductDto> findProductByBrand(@PathVariable String brand) {
        return productServiceImplement.getProductsByBrand(brand);
    }

}
