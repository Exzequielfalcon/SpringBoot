package hello.Service;
import hello.Dao.UsuarioRepo;
import hello.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    @Autowired
    private UsuarioRepo users;

    public List<Usuario> getUsuarios(){
        ArrayList<Usuario> p = new ArrayList<Usuario>();
        users.findAll().forEach(p::add);
        return p;
    }

    public Usuario postUsuario(Usuario p){
        return users.save(p);
    }

    public Usuario putUsuario(Usuario p){
        return users.save(p);
    }

    public Usuario getUsuario(int id){
        return users.findById(id).get();
    }

    public Usuario deleteUsuario(int id){
        Usuario p = users.findById(id).get();
        users.deleteById(id);
        return p;
    }
}
