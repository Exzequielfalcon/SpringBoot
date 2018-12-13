package shop.controller;
import shop.DTOs.UserDto;
import shop.model.Usuario;
import shop.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService users;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation("Sing up")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto newUsuario(@RequestBody UserDto user) {
        Usuario usr = users.addNewUsuario(convertToEntity(user));
        return user;
    }

    @ApiOperation("List users")
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserDto> getUsuarios(){
        return convertToDto(users.getUsuarios());
    }

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public UserDto getUsuario(@PathVariable("id") int proid) {
        UserDto user = convertToDto(users.getUsuarioById(proid));
        if(user!=null){
            return user;
        }
        throw new IllegalArgumentException();
    }

    @ApiOperation("Modify user")
    @PutMapping("/{id}")
    public Usuario ModificarUsuario(@PathVariable("id") int proid,
                                      @RequestBody UserDto usuario){
        if(users.existsById(proid)){
            return users.editUsuario(proid, convertToEntity(usuario));
        }
        throw new IllegalArgumentException();
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete user by id")
    public UserDto deleteUsuario(@PathVariable("id") int proid){
        return convertToDto(users.deleteUsuario(proid));
    }

    private UserDto convertToDto(Usuario user) {
        return modelMapper.map(user, UserDto.class);

    }
    private List<UserDto> convertToDto(List<Usuario> users) {
        List<UserDto> dtoList=new ArrayList<UserDto>();
        for (Usuario u : users) {
            dtoList.add(convertToDto(u));
        }
        return dtoList ;

    }

    private Usuario convertToEntity(UserDto user) {
        return modelMapper.map(user, Usuario.class);
    }

}
