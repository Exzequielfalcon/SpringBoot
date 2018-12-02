package hello.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    private String nick;
    private String pass;

    @Autowired
    private Carrito carro;

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

    public Producto getItem(int id){
        return this.carro.getItem(id);
    }

    public void removeItem(int proid){
        this.carro.removeItem(proid);
    }

    public void addProdtoCarro(Producto p){
        carro.addProducto(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
