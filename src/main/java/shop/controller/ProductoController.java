package shop.controller;


import org.springframework.http.HttpStatus;
import shop.model.Producto;
import shop.services.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import shop.DTOs.ProductDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService prods;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/fill")
    @ApiOperation("Fill products")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Producto.class)})
    public String fillWithProducts() {
        prods.postProduct(new Producto("Guitarra", 200));
        prods.postProduct(new Producto("Mesa", 100));
        prods.postProduct(new Producto("Silla", 50));
        return "productos agregados";
    }

    @PostMapping
    @ApiOperation("Create new product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto newProducto(@RequestBody ProductDto producto) {
        Producto newProduct=prods.postProduct(convertToEntity(producto));
        return convertToDto(newProduct);
    }

    @GetMapping
    @ApiOperation("Get a list of products")
    public List<ProductDto> getProductos(){
        return convertToDto(prods.findAll());
    }

    @GetMapping("/{id}")
    public ProductDto getProducto(@PathVariable("id") int proid) {
        return convertToDto(prods.getProductById(proid));
    }

    @PutMapping("/{id}")
    @ApiOperation("Modify a product with id")
    public ProductDto ModificarProducto(@PathVariable("id") int proid, @RequestBody ProductDto producto){
       return convertToDto(prods.putProducto(proid,convertToEntity(producto)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete with id")
    public ProductDto DeleteProducto(@PathVariable("id") int proid){
        return convertToDto(prods.deleteProducto(proid));
    }

    private ProductDto convertToDto(Producto product) {
        return  modelMapper.map(product, ProductDto.class);

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
