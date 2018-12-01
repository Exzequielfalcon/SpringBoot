package hello.Controller;

import hello.Model.Producto;
import hello.Model.Usuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CarritoController {
//    @PostMapping("{username}/{id}")
//    @ApiOperation("Add item with id in the shopping cart")
//    public Producto addItemToCarro(@PathVariable("id") int proid,
//                                   @PathVariable("username") String usr) {
//        Usuario u = findUser(usr);
//        Producto p = ProductoController.getInstance().getProductbyID(proid);
//
//        if(u!=null && p!=null){
//            u.addProdtoCarro(p);
//        }
//        return p;
//    }
//
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
//
//    @GetMapping("{username}/carro")
//    @ApiOperation("Get items from carro")
//    public List<Producto> getCarrito(@PathVariable("username") String usr){
//        Usuario u = findUser(usr);
//        return u.getCarrito().getCarro();
//    }
}
