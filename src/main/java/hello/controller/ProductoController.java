package hello.controller;


import hello.model.Producto;
import hello.repos.ProductRepo;
import hello.services.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductRepo products;

    @Autowired
    private ProductoService prods;

    @PostMapping("/fill")
    @ApiOperation("Fill products")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public String fillWithProducts() {
        products.save(new Producto("Guitarra", 200));
        products.save(new Producto("Mesa", 100));
        products.save(new Producto("Silla", 50));
        return "productos agregados";
    }

    @PostMapping
    @ApiOperation("Create new product")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public Producto newProducto(@RequestBody Producto producto) {
        return prods.postProduct(producto);
    }

    @GetMapping
    @ApiOperation("Get a list of products")
    public List<Producto> getProductos(){
        return prods.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable("id") int proid) {
        return prods.getProductById(proid);
    }

    @PutMapping("/{id}")
    @ApiOperation("Modify a product with id")
    public Producto ModificarProducto(@PathVariable("id") int proid, @RequestBody Producto producto){
       return prods.putProducto(proid,producto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete with id")
    public Producto DeleteProducto(@PathVariable("id") int proid){
        return prods.deleteProducto(proid);
    }

}
