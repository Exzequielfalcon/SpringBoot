package shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", unique = true)
    private int id;

    @Column(name = "precio")
    private double precio;

    @Column(name = "item")
    private String item;

    public Producto(String item, double precio){
        this.precio=precio;
        this.item=item;
    }
}
