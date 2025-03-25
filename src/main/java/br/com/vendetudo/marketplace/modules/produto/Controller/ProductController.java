package br.com.vendetudo.marketplace.modules.produto.Controller;
import br.com.vendetudo.marketplace.modules.produto.Entity.ProductEntity;
import br.com.vendetudo.marketplace.modules.produto.Enums.ProductTypeEnum;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductWithThisBrandNotExistException;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Service.ProductServiceImplement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.net.ssl.HttpsURLConnection;
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
    public ResponseEntity <ProductDto> createProduct(@RequestBody @Valid ProductDto create){
        return  ResponseEntity.status(HttpStatus.CREATED).body(productServiceImplement.createProduct(create));
    }
    @PatchMapping("/{id}/atualizaproduto")
    public ProductDto updateProduct(@PathVariable Long id,@RequestBody @Valid ProductDto atualizar){
       return productServiceImplement.updateProduct(id,atualizar);
    }

    @PatchMapping("/{id}/addQuantity")
    public ResponseEntity<Void> addQuantity(@PathVariable Long id, @RequestParam  @PositiveOrZero Integer quantity) {
        productServiceImplement.addProductQuantity(id, quantity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-brand")
    public ResponseEntity<Map<Long, ProductDto>>returnBrandByBrand(@RequestParam(required = false) String brand) {
        try {
            return ResponseEntity.ok(productServiceImplement.getProductsByBrand(brand));
        } catch (ProductWithThisBrandNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/filterType")
    public ResponseEntity<List<ProductEntity>> filterTypeProduct(@RequestParam @Valid ProductTypeEnum type){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body ( productServiceImplement.getProductsByType(type));
        }catch (RuntimeException e){
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
