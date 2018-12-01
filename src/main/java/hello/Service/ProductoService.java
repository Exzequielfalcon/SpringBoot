package hello.Service;

import hello.Dao.ProductRepo;
import hello.Model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductRepo product;

    public List<Producto> getProductos(){
        ArrayList<Producto> p = new ArrayList<Producto>();
        product.findAll().forEach(p::add);
        return p;
    }

    public Producto postProducto(Producto p){
        return product.save(p);
    }

    public Producto putProducto(Producto p){
        return product.save(p);
    }

    public Producto getProducto(int id){
        return product.findById(id).get();
    }

    public Producto deleteProducto(int id){
        Producto p = product.findById(id).get();
        product.deleteById(id);
        return p;
    }
}
