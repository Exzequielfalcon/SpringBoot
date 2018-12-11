package shop.repos;

import shop.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CarritoRepo extends JpaRepository<Carrito, Integer> {
}
