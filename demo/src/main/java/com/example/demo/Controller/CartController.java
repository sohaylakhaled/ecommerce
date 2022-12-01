package com.example.demo.Controller;

import com.example.demo.Services.service_cart;
import com.example.demo.Services.service_product;
import com.example.demo.dto.Cartdto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.cartdtoadd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/cart")
public class CartController {
    @Autowired
    service_cart serviceCart;
    @GetMapping("/{id}")
    public Cartdto getCART(@PathVariable("id")Integer id){
        return serviceCart.getCart(id);
    }
    @PostMapping("/add")
    public void create(@RequestBody cartdtoadd cart) {
        serviceCart.addCart(cart);
    }
}
