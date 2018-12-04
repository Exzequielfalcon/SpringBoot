package hello.controller;

import hello.model.Item;
import hello.model.Producto;
import hello.model.Usuario;
import hello.repos.CarritoRepo;
import hello.repos.ProductRepo;
import hello.repos.UsuarioRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private UsuarioRepo user;

    @Autowired
    private ProductRepo prods;

    @Autowired
    private CarritoRepo carri;

//    @PostMapping("{username}/{ItemId}")
//    @ApiOperation("Add item with id in the shopping cart")
//    public Producto addItemToCarro(@PathVariable("ItemId") int proid,
//                                   @PathVariable("username") int usr) {
//        if (prods.existsById(proid)){
//            Producto p = prods.findById(proid).get();
//            Item i = new Item(1,p);
//            carri.save(i);
//            user.findById(usr).get().addProdtoCarro(i);
//            return p;
//        } else {
//            return new Producto("false",0);
//        }
//    }

//    @DeleteMapping("{username}/{id}")
//    @ApiOperation("Remove item with id in the shopping cart")
//    public Producto removeItem(@PathVariable("id") int proid,
//                               @PathVariable("username") String usr) {
//        Usuario u = findUser(usr);
//        Producto p = u.getItem(proid);
//
//        if(u!=null && p!=null){
//            u.removeItem(proid);
//        }
//        return p;
//    }

    @GetMapping("{username}/carro")
    @ApiOperation("Get items from carro")
    public List<Item> getCarrito(@PathVariable("id") int usr){
        return user.findById(usr).get().getCarrito().getItems();
    }
}
