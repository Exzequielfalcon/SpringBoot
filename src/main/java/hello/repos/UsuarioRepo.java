package hello.repos;

import hello.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByNick(String nick);
}
