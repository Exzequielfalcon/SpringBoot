package shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", unique = true)
    private int id;

    @Column(name ="cantidad")
    private int cantidad;

    @OneToOne
    @JoinColumn(name ="id_producto")
    private Producto producto;

    public Item(int cantidad, Producto p) {
        this.cantidad = cantidad;
        this.producto = p;
    }

}
