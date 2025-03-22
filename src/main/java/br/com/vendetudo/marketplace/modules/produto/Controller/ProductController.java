package br.com.vendetudo.marketplace.modules.produto.Controller;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductWithThisBrandNotExistException;
import br.com.vendetudo.marketplace.modules.produto.ProductDto.ProductDto;
import br.com.vendetudo.marketplace.modules.produto.Service.ProductServiceImplement;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.util.Map;

@RequestMapping("produtos")
@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
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
    @ExceptionHandler(ProductWithThisBrandNotExistException.class)
    @GetMapping("/by-brand")
    public ResponseEntity<Map<Long, ProductDto>> returnProductsBrand(@RequestParam(required = false) String brand) {
        if(brand == null || brand.trim().isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of());
        }
        try {
            return ResponseEntity.ok(productServiceImplement.getProductsByBrand(brand));
        } catch (ProductWithThisBrandNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
