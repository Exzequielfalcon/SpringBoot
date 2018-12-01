package hello.Dao;

import hello.Model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Producto, Integer> {
}
