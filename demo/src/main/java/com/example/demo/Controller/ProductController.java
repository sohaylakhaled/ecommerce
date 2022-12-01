package com.example.demo.Controller;

import com.example.demo.Services.service_product;

import com.example.demo.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/v2/product")
public class ProductController {
    @Autowired
    service_product serviceProduct;


    @PostMapping("/add")
    public void create(@RequestBody
                              ProductDto productDto){
    serviceProduct.addproduct(productDto);


      //  return new ResponseEntity<>(new ApiResponse(true,"added successsfully"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<ProductDto> getstudent(){
        return serviceProduct.getallproducts();
    }
    @PutMapping ("/edit/{id}")
    public void update(@PathVariable("id")Integer id,@RequestBody ProductDto dto
                       ){
        serviceProduct.Update(id,dto);


        //  return new ResponseEntity<>(new ApiResponse(true,"added successsfully"), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id")Integer id){
        serviceProduct.delete(id);
    }

}
