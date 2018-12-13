package shop.services;

import org.springframework.web.servlet.HandlerExceptionResolver;
import shop.model.Producto;
import shop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductRepo products;

    public Producto postProduct(Producto p){
        if(p.getItem().isEmpty()){
            throw new NullPointerException();
        }
        return products.save(p);
    }

    public Producto deleteProducto(int id){
        if(products.existsById(id)){
            Producto p = products.findById(id).get();
            products.deleteById(id);
            return p;
        } else throw new IllegalArgumentException();
    }

    public Producto getProductById(int id){
        if(products.existsById(id)){
            Producto p = products.findById(id).get();
            return p;
        } else throw new IllegalArgumentException();
    }

    public List<Producto> findAll(){
        return products.findAll();
    }

    public Producto putProducto(int id, Producto p){
        if(products.existsById(id)){
            p.setId(id);
            return products.save(p);
        } else throw new IllegalArgumentException();
    }
}
