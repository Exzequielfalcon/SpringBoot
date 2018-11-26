package hello.Controller;

import hello.Model.Producto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    private static List<Producto> productos = new ArrayList<>();
    private static int id=0;
    public static ProductoController instance = null;

    protected ProductoController() {
        // Exists only to defeat instantiation.
    }
    public static ProductoController getInstance() {
        if(instance == null) {
            instance = new ProductoController();
        }
        return instance;
    }

    public String getString(){
        return "hola";
    }

    @PostMapping
    @ApiOperation("Fill products")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public String fillWithProducts() {
        productos.add(new Producto("Guitarra", 200));
        productos.get(id).setId(id);
        id++;
        productos.add(new Producto("Mesa", 100));
        productos.get(id).setId(id);
        id++;
        productos.add(new Producto("Silla", 50));
        productos.get(id).setId(id);
        id++;
        return "productos agregados";
    }

//    @PostMapping
//    @ApiOperation("Create new product")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
//    public Producto newProducto(@RequestBody Producto producto) {
//        productos.add(producto);
//        productos.get(id).setId(id);
//        id++;
//        return producto;
//    }

    @GetMapping
    @ApiOperation("Get a list of products")
    public List<Producto> getProductos(){
        return new ArrayList<Producto>(this.productos);
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable("id") int proid) {
        Producto prod = getProductbyID(proid);
        if(prod!=null){
            return prod;
        }
        throw new IllegalArgumentException();
    }

    public Producto getProductbyID(int proid){
        for (Producto p : productos) {
            if (p.getId() == proid) {
                return p;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Producto ModificarProducto(@PathVariable("id") int proid,
                                      @RequestBody Producto producto){
       Producto prod = getProductbyID(proid);
       if(prod!=null){
           productos.remove((int)proid);
           productos.add(producto);
           productos.get(productos.size()-1).setId(proid);
           return prod;
       }
        throw new IllegalArgumentException();
    }

    @DeleteMapping("/{id}")
    public Producto DeleteProducto(@PathVariable("id") int proid){
        productos.remove(proid);
        return null;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }
}
