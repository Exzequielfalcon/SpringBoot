package hello.Dao;

import hello.Model.Producto;

import java.util.Collection;

public interface ProductDao {
    Collection<Producto> getProductos();

    Producto getProductoById(int id);

    void deleteProducto(int id);

    void putProducto(Producto p);

    void postProducto(Producto p);
}
