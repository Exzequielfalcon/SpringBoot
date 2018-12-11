package shop.DTOs;

import java.util.List;

public class CartDto {

    private int id;
    private UserDto user;
    private List<ProductDto> products;

    public CartDto() {}

    public CartDto(int id, UserDto user, List<ProductDto> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }


}
