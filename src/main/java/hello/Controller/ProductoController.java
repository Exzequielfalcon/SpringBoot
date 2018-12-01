package hello.Controller;

import hello.Model.Producto;
import hello.Service.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService products;

    @PostMapping("/fill")
    @ApiOperation("Fill products")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public String fillWithProducts() {
        products.postProducto(new Producto("Guitarra", 200));
        products.postProducto(new Producto("Mesa", 100));
        products.postProducto(new Producto("Silla", 50));
        return "productos agregados";
    }

    @PostMapping
    @ApiOperation("Create new product")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public Producto newProducto(@RequestBody Producto producto) {
        return products.postProducto(producto);
    }

    @GetMapping
    @ApiOperation("Get a list of products")
    public List<Producto> getProductos(){
        return products.getProductos();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable("id") int proid) {
        return products.getProducto(proid);
    }

    @PutMapping("/{id}")
    @ApiOperation("Modify a product with id")
    public Producto ModificarProducto(@PathVariable("id") int proid,
                                      @RequestBody Producto producto){
        producto.setId(proid);
       return products.putProducto(producto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete with id")
    public Producto DeleteProducto(@PathVariable("id") int proid){
        return products.deleteProducto(proid);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to Dao
    }
}
