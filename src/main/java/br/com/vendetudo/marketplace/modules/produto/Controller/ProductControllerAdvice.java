package br.com.vendetudo.marketplace.modules.produto.Controller;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductNotFoundException;
import br.com.vendetudo.marketplace.modules.produto.Exception.ProductWithThisBrandNotExistException;
import br.com.vendetudo.marketplace.modules.produto.Exception.QuantityLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(ProductNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(QuantityLimitException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleQuantityException(QuantityLimitException ex){
        return  ex.getMessage();
    }

    @ExceptionHandler(ProductWithThisBrandNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String brandNotFound(ProductWithThisBrandNotExistException ex){
        return  ex.getMessage();
    }

}
