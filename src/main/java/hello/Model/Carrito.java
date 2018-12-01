package hello.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> carro = new ArrayList<>();

    public Carrito(){}

    public void addProducto(Producto p){
        carro.add(p);
    }

    public void removeProducto(int id){
        carro.remove(id);
    }

    public double getTotal(){
        double aux=0;
        for(Producto p:carro){
            aux+=p.getPrecio();
        }
        return aux;
    }

    public Producto getItem(int id){
        return this.carro.get(id);
    }

    public void removeItem(int id){
        this.carro.remove(id);
    }

    public List<Producto> getCarro(){
        return new ArrayList<Producto>(this.carro);
    }
}
