package com.example.demo.Controller;

import com.example.demo.Services.service_product;
import com.example.demo.Services.service_productline;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductLinedto;
import com.example.demo.dto.productlineviewdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/productline")
public class ProductLIneController {
    @Autowired
    service_productline service_productline;


    @PostMapping("/add")
    public void create(@RequestBody
                       ProductLinedto productlineDto){
     service_productline.addproduct(productlineDto);


        //  return new ResponseEntity<>(new ApiResponse(true,"added successsfully"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<productlineviewdto> getproductline(){
        return service_productline.getallproductslines();
    }
    @PutMapping ("/edit/{id}")
    public void update(@PathVariable("id")Integer id,@RequestBody ProductLinedto dto
    ){
        service_productline.Update(id,dto);


        //  return new ResponseEntity<>(new ApiResponse(true,"added successsfully"), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id")Integer id){
        service_productline.delete(id);
    }

}
