package com.example.demo.Services;

import com.example.demo.classes.Cart;
import com.example.demo.classes.Customer;
import com.example.demo.dto.Cartdto;
import com.example.demo.dto.cartdtoadd;
import com.example.demo.repository.CartReprositry;
import com.example.demo.repository.CustomerReprositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_cart {
    @Autowired
    CartReprositry cartReprositry;
    @Autowired
    CustomerReprositry customerReprositry;
@Autowired
service_productline serviceProductline;
@Autowired
sevice_customer sevice_customer;
    public Cartdto getCart(Integer id) {

        Customer customer= sevice_customer.getCustomer(id);
        Cart cart=customer.getCart();
        Cartdto cartdto = new Cartdto();
        cartdto.setTotalprice(cart.getTotalprice());
        cartdto.setQuantityOfProductline(cart.getQuantityOfProductline());

        return cartdto;
    }


    public void addCart(cartdtoadd Cartdtoadd) {
        Cart cart = new Cart();
        cart.setProductLineList(serviceProductline.getAllProducts());

       Customer customer= sevice_customer.getCustomer(Cartdtoadd.getCustomerid());
       customer.setCart(cart);


        cartReprositry.save(cart);
        customerReprositry.save(customer);
    }

}
