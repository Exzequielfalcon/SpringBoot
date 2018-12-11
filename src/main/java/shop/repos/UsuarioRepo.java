package shop.repos;

import shop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByNick(String nick);
}
