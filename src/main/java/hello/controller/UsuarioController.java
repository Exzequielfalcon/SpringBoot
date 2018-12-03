package hello.controller;
import hello.model.Usuario;
import hello.model.UsuarioForm;
import hello.repos.UsuarioRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepo users;

    @PostMapping
    @ApiOperation("Sing up")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario newUsuario(@RequestBody UsuarioForm user) {
        Usuario p= new Usuario(user.getNick(),user.getPass());
        return users.save(p);
    }

    @ApiOperation("List users")
    @GetMapping
    public List<Usuario> getUsuarios(){
        return users.findAll();
    }

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable("id") int proid) {
        Usuario user = users.findById(proid).get();
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
        users.save(usuario);
        throw new IllegalArgumentException();
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete user by id")
    public Usuario deleteUsuario(@PathVariable("id") int proid){
        Usuario user = users.findById(proid).get();
        users.deleteById(proid);
        return user;
    }




//    public Usuario findUser(String nombre){
//        for(Usuario u:usuarios){
//            if(u.getNick().equals(nombre)){
//                return u;
//            }
//        }
//        return null;
//    }

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
//            reason = "Request ID not found.")
//    @ExceptionHandler(IllegalArgumentException.class)
//    public void badIdExceptionHandler() {
//        // Nothing to repos
//    }
}
