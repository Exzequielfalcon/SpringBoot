package hello.Controller;

import hello.Model.Producto;
import hello.Model.Usuario;
import hello.Model.Usuario;
import hello.Model.UsuarioForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private static int id=0;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario newUsuario(@RequestBody UsuarioForm usr) {
        Usuario usuario = new Usuario(usr);
        usuarios.add(usuario);
        usuarios.get(id).setId(id);
        id++;
        return usuario;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return new ArrayList<Usuario>(this.usuarios);
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable("id") int proid) {
        Usuario prod = getProductbyID(proid);
        if(prod!=null){
            return prod;
        }
        throw new IllegalArgumentException();
    }

    public Usuario getProductbyID(int proid){
        for (Usuario u : usuarios) {
            if (u.getId() == proid) {
                return u;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Usuario ModificarUsuario(@PathVariable("id") int proid,
                                      @RequestBody Usuario usuario){
        Usuario prod = getProductbyID(proid);
        if(prod!=null){
            usuarios.remove(proid);
            usuarios.add(usuario);
            usuarios.get(usuarios.size()-1).setId(proid);
            return prod;
        }
        throw new IllegalArgumentException();
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable("id") int proid){
        usuarios.remove(proid);
        return "Usuario con el id " + proid + " eliminado";
    }

    @PostMapping("{username}/{id}")
    public Producto addItemToCarro(@PathVariable("id") int proid,
                                   @PathVariable("username") String usr) {
        Usuario u = findUser(usr);
        Producto p = ProductoController.getInstance().getProductbyID(proid);

        if(u!=null && p!=null){
           u.addProdtoCarro(p);
        }
        return p;
    }

    @GetMapping("{username}/carro")
    public List<Producto> getCarrito(@PathVariable("username") String usr){
        Usuario u = findUser(usr);
        return u.getCarrito().getCarro();
    }

    public Usuario findUser(String nombre){
        for(Usuario u:usuarios){
            if(u.getNick().equals(nombre)){
                return u;
            }
        }
        return null;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }
}
