package shop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true)
    private int id;

    @Column(name="nick", unique = true)
    private String nick;

    @Column(name="pass")
    private String pass;

    @OneToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carro;

    public Usuario(String nick, String pass) {
        this.nick = nick;
        this.pass = pass;
    }

    public Carrito getCarrito(){
        return this.carro;
    }

    public List<Item> getItems(){
        return this.carro.getItems();
    }

    public void removeItem(int proid){
        this.carro.removeItem(proid);
    }

    public void addProdtoCarro(Item p){
        carro.addProducto(p);
    }

}
