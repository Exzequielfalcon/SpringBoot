package hello.services;

import hello.model.Usuario;
import hello.repos.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo users;

    public Usuario getUsuarioById(int id) {
        Usuario Usuario = users.findById(id).get();
        if(Usuario!=null){
            return Usuario;
        }
        throw new IllegalArgumentException();
    }

    public List<Usuario> getUsuarios(){
        return users.findAll();
    }

    public Usuario addNewUsuario(Usuario usuario) {

        return users.save(usuario);
    }
    public Usuario deleteUsuario(int id) {
        if(users.existsById(id))  {
            Usuario usuario = users.findById(id).get();
            users.deleteById(id);
            return usuario;
        }
        else{
            throw new IllegalArgumentException();
        }


    }


    public Usuario editUsuario(int id,Usuario usuario){
        if(users.existsById(id))  {
            usuario.setId(id);
            return users.save(usuario);
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    public boolean existsById(int user){
        return users.existsById(user);
    }
}
