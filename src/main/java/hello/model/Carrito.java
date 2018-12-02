package hello.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Carrito {

    @Id @GeneratedValue
    private int id;

    @ElementCollection(targetClass= Producto.class)
    private List<Producto> carro = new ArrayList<>();

    public Carrito(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarro(List<Producto> carro) {
        this.carro = carro;
    }

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
