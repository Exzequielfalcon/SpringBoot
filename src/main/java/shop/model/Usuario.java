package shop.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "Usuario")
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

    public Carrito getCarro() {
        return carro;
    }

    public Usuario(){}

    public Usuario(String nick, String pass) {
        this.nick = nick;
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Carrito getCarrito(){
        return this.carro;
    }

    public List<Item> getItems(){
        return this.carro.getItems();
    }

    public void setCarro(Carrito c){
        this.carro=c;
    }

    public void removeItem(int proid){
        this.carro.removeItem(proid);
    }

    public void addProdtoCarro(Item p){
        carro.addProducto(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}