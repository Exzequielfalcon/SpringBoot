package hello.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nick;
    private String pass;
    private Carrito carro = new Carrito();
    private static int id;

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

    public void addProdtoCarro(Producto p){
        carro.addProducto(p);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuario.id = id;
    }
}
