package hello.Dao;

import hello.Model.Producto;
import hello.Model.Usuario;

import java.util.Collection;

public interface UsuarioDao {
    Collection<Usuario> getUsuarios();

    Usuario getUsuarioById(int id);

    void deleteUsuario(int id);

    void putUsuario(Usuario u);

    void postUsuario(Usuario u);
}
