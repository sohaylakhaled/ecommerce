package com.example.demo.Services;

import com.example.demo.classes.Customer;
import com.example.demo.classes.product;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.repository.CustomerReprositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class sevice_customer {
    @Autowired
    private final CustomerReprositry customerReprositry;
@Autowired
    public sevice_customer(CustomerReprositry customerReprositry) {
        this.customerReprositry = customerReprositry;
    }

    public Customer getCustomer(Integer id){
    Optional<Customer> customer=customerReprositry.findById(id);
   return customer.get();

    }

    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customerReprositry.save(customer);
    }

    public List<CustomerDto> getallcustomers() {
        List<Customer>allcustomers=customerReprositry.findAll();
        List<CustomerDto>customerDtos= new ArrayList<>();

        for (Customer customer : allcustomers){
            customerDtos.add(getCustomers(customer));
        }
        return customerDtos;
    }

    private CustomerDto getCustomers(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());

        customerDto.setId(customer.getId());
        return customerDto;
    }

    public void delete(Integer id) {
        boolean exsits=customerReprositry.existsById(id);
        if(!exsits){
            throw new IllegalStateException("id"+id+" not exsits");
        }
        customerReprositry.deleteById(id);
    }
}
