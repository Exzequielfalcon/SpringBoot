package hello.repos;

import hello.model.Carrito;
import hello.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CarritoRepo extends JpaRepository<Carrito, Integer> {
}
