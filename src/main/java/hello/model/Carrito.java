package hello.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


@Entity
@Data
@AllArgsConstructor
public class Carrito {

    @Column(name = "id_carrito")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name ="id_item")
    private List<Item> carro;

    public Carrito(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProducto(Item p){
        carro.add(p);
    }

    public List<Item> getItems(){
        return new ArrayList<>(this.carro);
    }

    public void removeProducto(int id){
        carro.remove(id);
    }

    public double getTotal(){
        double aux=0;
        for(Item p:carro){
            aux+=p.getProducto().getPrecio();
        }
        return aux;
    }

    public void removeItem(int id){
        this.carro.remove(id);
    }
}
