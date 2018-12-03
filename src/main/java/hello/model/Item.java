package hello.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", unique = true)
    private int id;

    private int cantidad;

    @OneToOne
    @JoinColumn(name ="id_producto")
    private Producto producto;

    @Column(name = "ItemId")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto p) {
        this.producto = p;
    }

    public Item(int cantidad, Producto p) {
        this.cantidad = cantidad;
        this.producto = p;
    }

    public Item(){}
}
