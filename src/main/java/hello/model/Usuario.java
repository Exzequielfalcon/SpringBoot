package hello.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Table(name = "Usuario")
@Entity
@Data
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true)
    private int id;

    @Column(name="nick")
    private String nick;

    @Column(name="pass")
    private String pass;

    @OneToOne
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
