package hello.repos;

import hello.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
}
