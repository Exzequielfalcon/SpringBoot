package hello.controller;

import hello.model.Item;
import hello.model.Producto;
import hello.model.Usuario;
import hello.repos.CarritoRepo;
import hello.repos.ProductRepo;
import hello.repos.UsuarioRepo;
import hello.services.CarritoService;
import hello.services.ProductoService;
import hello.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carri;

    @Autowired
    private UsuarioService users;

    @Autowired
    private ProductoService prods;


    @PostMapping("{username}/{ItemId}")
    @ApiOperation("Add item with id in the shopping cart")
    public Producto addItemToCarro(@PathVariable("ItemId") int proid,
                                   @PathVariable("username") String usr) {
        return carri.addItem(prods.getProductById(proid),usr);
    }

    @DeleteMapping("{username}/{id}")
    @ApiOperation("Remove item with id in the shopping cart")
    public Producto removeItem(@PathVariable("id") int proid,
                               @PathVariable("username") String usr) {
        return carri.removeItem(proid, usr);
    }


    @GetMapping("{username}/carro")
    @ApiOperation("Get items from carro")
    public List<Item> getCarrito(@PathVariable("id") String usr){
        return carri.getProductos(usr);
    }
}
