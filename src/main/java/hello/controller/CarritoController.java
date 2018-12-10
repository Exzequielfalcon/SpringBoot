package hello.controller;

import hello.DTOs.ItemDto;
import hello.DTOs.ProductDto;
import hello.model.Carrito;
import hello.model.Item;
import hello.model.Producto;
import hello.model.Usuario;
import hello.repos.CarritoRepo;
import hello.repos.ProductRepo;
import hello.repos.UsuarioRepo;
import hello.services.CarritoService;
import hello.services.ProductoService;
import hello.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carri;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductoService prods;


    @PostMapping("{username}/{ItemId}")
    @ApiOperation("Add item with id in the shopping cart")
    public Carrito addItemToCarro(@PathVariable("ItemId") int proid,
                                   @PathVariable("username") String usr) {
        return carri.addItem(prods.getProductById(proid),usr);
    }

    @DeleteMapping("{username}/{id}")
    @ApiOperation("Remove item with id in the shopping cart")
    public ProductDto removeItem(@PathVariable("id") int proid,
                               @PathVariable("username") String usr) {
        return convertToDto(carri.removeItem(proid, usr));
    }

    @GetMapping("{username}/total")
    @ApiOperation("Get total")
    public double getItemById(@PathVariable("username") String usr){
        return carri.getTotal(usr);
    }

    @GetMapping("{username}")
    @ApiOperation("Get items from cart")
    public List<Item> getCarrito(@PathVariable("username") String usr){
        return carri.getProductos(usr);
    }

    private ProductDto convertToDto(Producto product) {
        return  modelMapper.map(product, ProductDto.class);
    }

    private ItemDto convertToDto(Item product) {
        return  modelMapper.map(product, ItemDto.class);
    }

    private List<ItemDto> convertToItemDto(List<Item> products) {
        List<ItemDto> dtoList=new ArrayList<ItemDto>();
        for (Item product : products) {
            dtoList.add(convertToDto(product));
        }
        return dtoList;
    }

    private List<ProductDto> convertToDto(List<Producto> products) {
        List<ProductDto> dtoList=new ArrayList<ProductDto>();
        for (Producto product : products) {
            dtoList.add(convertToDto(product));
        }
        return dtoList ;
    }

    private Producto convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Producto.class);
    }
}
