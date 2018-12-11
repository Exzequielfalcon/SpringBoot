package shop.repos;

import shop.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepo extends JpaRepository<Producto, Integer> {
}
