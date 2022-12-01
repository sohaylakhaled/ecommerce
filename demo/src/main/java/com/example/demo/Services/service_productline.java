package com.example.demo.Services;

import com.example.demo.classes.ProductLine;
import com.example.demo.classes.product;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductLinedto;
import com.example.demo.dto.productlineviewdto;
import com.example.demo.repository.ProductLineReprositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class service_productline {
    @Autowired
    ProductLineReprositry productLineReprositry;
    @Autowired
    service_product serviceProduct;


    public void addproduct(ProductLinedto productlineDto) {
        product Product=serviceProduct.getProduct(productlineDto.getProductId());
        ProductLine productLine=new ProductLine();
        productLine.setProductquantity(productlineDto.getProductquantity());
     //   productLine.setTotalprice(productlineDto.getProductquantity()*productLine.getProduct().getPrice());
        productLine.setProduct(Product);
        productLineReprositry.save(productLine);

    }

    public List<productlineviewdto> getallproductslines() {
        List<ProductLine> productlineviewdtos= productLineReprositry.findAll();
        List<productlineviewdto>productDtos= new ArrayList<>();

        for (ProductLine Product : productlineviewdtos){
            productDtos.add(getproduct(Product));
        }
        return productDtos;

    }

    private productlineviewdto getproduct(ProductLine product) {
        productlineviewdto d= new productlineviewdto();
        d.setTotalprice(product.getTotalprice());
        d.setId(product.getId());
        d.setProductquantity(product.getProductquantity());
        return  d;
    }

    public void Update(Integer id, ProductLinedto dto) {
        Optional<ProductLine> OptProduct=productLineReprositry.findById(id);
        if(!OptProduct.isPresent()){
            throw new IllegalStateException("product not found");

        }
        ProductLine Product = OptProduct.get();
//Product.setDescription(desc);
//Product.setPrice(price);
//Product.setproductname(name);

        Product.setProductquantity(dto.getProductquantity());

        productLineReprositry.save(Product);



    }
    public List<ProductLine>getAllProducts(){
        return productLineReprositry.findAll();
    }

    public void delete(Integer id) {
        boolean exsits=productLineReprositry.existsById(id);
        if(!exsits){
            throw new IllegalStateException("id"+id+" not exsits");
        }
        productLineReprositry.deleteById(id);
    }


//    public List<ProductDto> getallproductslines() {
//
//    }
}
