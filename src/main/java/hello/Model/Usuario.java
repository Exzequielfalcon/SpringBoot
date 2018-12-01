package hello.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nick;
    private String pass;
    private Carrito carro = new Carrito();


    public Usuario(String nick) {
        this.nick = nick;
        this.pass = pass;
    }

    public Usuario(UsuarioForm u){
        this.nick = u.getNick();
        this.pass = u.getPass();
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
