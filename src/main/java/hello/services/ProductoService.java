package hello.services;

import hello.model.Producto;
import hello.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductRepo products;

    public Producto postProduct(Producto p){
        return products.save(p);
    }

    public Producto deleteProducto(int id){
        Producto p = products.findById(id).get();
        products.deleteById(id);
        return p;
    }

    public Producto getProductById(int id){
        Producto p = products.findById(id).get();
        return p;
    }

    public List<Producto> findAll(){
        return products.findAll();
    }

    public Producto putProducto(int id, Producto p){
        p.setId(id);
        return products.save(p);
    }
}
