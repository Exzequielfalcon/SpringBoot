package hello.services;

import hello.model.Carrito;
import hello.model.Item;
import hello.model.Producto;
import hello.model.Usuario;
import hello.repos.CarritoRepo;
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
        aux.addProdtoCarro(i);
        return p;
    }

    public Carrito addCarrito(Carrito c){
       return carri.save(c);
    }

    public Producto removeItem(int proid, String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        Producto p = aux.getCarrito().removeItem(proid);
        return p;
    }

    public List<Item> getProductos(String usr){
        Usuario aux =users.getUsuarioByNick(usr);
        return aux.getCarrito().getItems();
    }
}
