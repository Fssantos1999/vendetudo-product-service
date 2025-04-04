package br.com.vendetudo.marketplace.modules.produto.Controller;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Service.ProductServiceImplement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ProductDto createProduct(@RequestBody @Valid ProductDto create) {
        return productServiceImplement.createProduct(create);
    }

    @PatchMapping("/{id}/atualizaproduto")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDto atualizar) {
        return productServiceImplement.updateProduct(id, atualizar);
    }

    @PatchMapping("/{id}/addQuantity")
    public void addQuantity(@PathVariable Long id, @RequestParam @PositiveOrZero Integer quantity) {
        productServiceImplement.addProductQuantity(id, quantity);

    }

    @GetMapping("/filter")
    public Map<Long, ProductDto> returnBrandByBrand(@RequestParam(required = false) String brand) {
        return productServiceImplement.getProductsByBrand(brand);
    }
    @GetMapping("/filtertype")
    public List<ProductEntity>filterTypeProduct(@RequestParam @Valid ProductTypeEnum type) {
        return productServiceImplement.getProductsByType(type);
    }

    @PatchMapping("/{productId}/price")
    public ProductDto updateProductPrice(@PathVariable Long productId, @RequestBody ProductDto priceUpdateRequest) {
        return productServiceImplement.updateProductPrice(productId, priceUpdateRequest.getPrice());
    }

    @GetMapping()
    public List <ProductDto> listarProdutosComBaixoEstoque(@PathVariable Integer  quantity ){
        return  productServiceImplement.getLowStockProducts(quantity);
    }


}