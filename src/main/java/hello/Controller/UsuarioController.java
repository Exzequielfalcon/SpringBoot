package hello.Controller;
import hello.Model.Producto;
import hello.Model.Usuario;
import hello.Model.Usuario;
import hello.Model.UsuarioForm;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Sing up")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario newUsuario(@RequestBody UsuarioForm usr) {
        Usuario usuario = new Usuario(usr);
        usuarios.add(usuario);
        usuarios.get(id).setId(id);
        id++;
        return usuario;
    }

    @ApiOperation("List users")
    @GetMapping
    public List<Usuario> getUsuarios(){
        return new ArrayList<Usuario>(this.usuarios);
    }

    @ApiOperation("Get user by id")
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

    @ApiOperation("Modify user")
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
    @ApiOperation("Delete user by id")
    public String deleteUsuario(@PathVariable("id") int proid){
        usuarios.remove(proid);
        return "Usuario con el id " + proid + " eliminado";
    }


    @PostMapping("{username}/{id}")
    @ApiOperation("Add item with id in the shopping cart")
    public Producto addItemToCarro(@PathVariable("id") int proid,
                                   @PathVariable("username") String usr) {
        Usuario u = findUser(usr);
        Producto p = ProductoController.getInstance().getProductbyID(proid);

        if(u!=null && p!=null){
           u.addProdtoCarro(p);
        }
        return p;
    }

    @DeleteMapping("{username}/{id}")
    @ApiOperation("Remove item with id in the shopping cart")
    public Producto removeItem(@PathVariable("id") int proid,
                                   @PathVariable("username") String usr) {
        Usuario u = findUser(usr);
        Producto p = u.getItem(proid);

        if(u!=null && p!=null){
            u.removeItem(proid);
        }
        return p;
    }

    @GetMapping("{username}/carro")
    @ApiOperation("Get items from carro")
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
