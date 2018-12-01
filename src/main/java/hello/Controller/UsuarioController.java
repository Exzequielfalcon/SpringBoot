package hello.Controller;
import hello.Model.Producto;
import hello.Model.Usuario;
import hello.Model.Usuario;
import hello.Model.UsuarioForm;
import hello.Service.ProductoService;
import hello.Service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UsuarioService users;

    @PostMapping
    @ApiOperation("Sing up")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario newUsuario(@RequestBody Usuario usr) {
        return users.postUsuario(usr);
    }

    @ApiOperation("List users")
    @GetMapping
    public List<Usuario> getUsuarios(){
        return users.getUsuarios();
    }

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable("id") int proid) {
        Usuario user = users.getUsuario(proid);
        if(user!=null){
            return user;
        }
        throw new IllegalArgumentException();
    }

    @ApiOperation("Modify user")
    @PutMapping("/{id}")
    public Usuario ModificarUsuario(@PathVariable("id") int proid,
                                      @RequestBody Usuario usuario){
        usuario.setId(proid);
        users.postUsuario(usuario);
        throw new IllegalArgumentException();
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete user by id")
    public Usuario deleteUsuario(@PathVariable("id") int proid){
        return users.deleteUsuario(proid);
    }




//    public Usuario findUser(String nombre){
//        for(Usuario u:usuarios){
//            if(u.getNick().equals(nombre)){
//                return u;
//            }
//        }
//        return null;
//    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to Dao
    }
}
