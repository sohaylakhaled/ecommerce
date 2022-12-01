package com.example.demo.Controller;


import com.example.demo.Services.service_cart;
import com.example.demo.Services.service_product;
import com.example.demo.Services.sevice_customer;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/Customer")
public class CustomerController {
    @Autowired
    sevice_customer sevice_customer;
    @PostMapping("/add")
    public void create(@RequestBody
                       CustomerDto customerDto) {
        sevice_customer.addCustomer(customerDto);
    }
    @GetMapping("/")
    public List<CustomerDto> getcustomer(){
        return sevice_customer.getallcustomers();
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id")Integer id){
        sevice_customer.delete(id);
    }

}
