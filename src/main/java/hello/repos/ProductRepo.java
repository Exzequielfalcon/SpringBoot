package hello.repos;

import hello.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ProductRepo extends JpaRepository<Producto, Integer> {
}
