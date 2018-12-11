package shop.services;

import shop.model.Carrito;
import shop.model.Item;
import shop.model.Producto;
import shop.model.Usuario;
import shop.repos.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepo carri;

    @Autowired
    private UsuarioService users;

    public Producto addItem(Producto p, String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        Item i = new Item(1,p);
        Carrito s=carri.getOne(aux.getId());
        s.addProducto(i);
        carri.save(s);
        return p;
    }

    public Producto addItem(Producto p, String usr, int cantidad){
        Usuario aux =users.getUsuarioByNick(usr);
        Item i = new Item(cantidad,p);
        Carrito s=carri.getOne(aux.getId());
        s.addProducto(i);
        carri.save(s);
        return p;
    }

    public Carrito addCarrito(Carrito c){
       return carri.save(c);
    }

    public Producto removeItem(int proid, String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        Carrito s=carri.getOne(aux.getId());
        Producto p = s.removeItem(proid);
        carri.save(s);
        return p;
    }

    public List<Item> getProductos(String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        return aux.getItems();
    }

    public Carrito getCarrito(String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        return aux.getCarrito();
    }

    public double getTotal(String usr) {
        Usuario aux = users.getUsuarioByNick(usr);
        return aux.getCarrito().getTotal();
    }
}
