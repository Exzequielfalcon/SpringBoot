package shop.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
public class Carrito {

    @Column(name = "id_carrito")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Item> carro;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario user;

    public Carrito(){}

    public Carrito(Usuario user){
        this.user=user;
    }

    public List<Item> getCarro() {
        return carro;
    }

    public void setCarro(List<Item> carro) {
        this.carro = carro;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

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
        for(Item i:carro){
            aux+=(i.getProducto().getPrecio()*i.getCantidad());
        }
        return aux;
    }

    public Producto removeItem(int id){
        for(int i=0;i<carro.size();i++){
            if(carro.get(i).getProducto().getId()==id){
                Producto p = carro.get(i).getProducto();
                carro.remove(i);
                return p;
            }
        }
        return null;
    }
}
