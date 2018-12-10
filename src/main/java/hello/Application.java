package hello;

import hello.model.Producto;
import hello.model.Usuario;
import hello.services.ProductoService;
import hello.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuarioService users, ProductoService prods) {

        Usuario c1 = new Usuario("Eze", "kilo");
        Usuario c2 = new Usuario("juan", "asd");

        Producto p1 = new Producto("mesa", 100);
        Producto p2 = new Producto("Joystick", 200);
        Producto p3 = new Producto("Celiu", 150);
        Producto p4 = new Producto("botella", 111);
            return (args) -> {
                users.addNewUsuario(c1);
                users.addNewUsuario(c2);
                prods.postProduct(p1);
                prods.postProduct(p2);
                prods.postProduct(p3);
                prods.postProduct(p4);

            };

        
        }
    }