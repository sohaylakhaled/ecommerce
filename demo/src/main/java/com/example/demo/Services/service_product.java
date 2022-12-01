package com.example.demo.Services;

import com.example.demo.classes.product;
import com.example.demo.dto.ProductDto;
import com.example.demo.repository.PoductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class service_product {
    @Autowired
    PoductRepositry poductRepositry;

    public void addproduct(ProductDto productDto) {
        product Product = new product();
        Product.setDescription(productDto.getDescription());
        Product.setPrice(productDto.getPrice());
        Product.setproductname(productDto.getProductname());

        poductRepositry.save(Product);
    }
    public ProductDto getproduct(product Product) {
        ProductDto ProductDTO = new ProductDto();
        ProductDTO.setDescription(Product.getDescription());
        ProductDTO.setPrice(Product.getPrice());
        ProductDTO.setProductname(Product.getproductname());
        ProductDTO.setId(Product.getId());
       return ProductDTO;
    }

    public List<ProductDto> getallproducts() {
        List<product>allproducts=poductRepositry.findAll();
        List<ProductDto>productDtos= new ArrayList<>();

        for (product Product : allproducts){
            productDtos.add(getproduct(Product));
        }
return productDtos;
    }
    @Transactional
//    public void Update(String name,String desc,int price,Integer id,ProductDto dto) {
    public void Update(Integer id,ProductDto dto) {
Optional<product> OptProduct=poductRepositry.findById(id);
if(!OptProduct.isPresent()){
    throw new IllegalStateException("product not found");

}
product Product = OptProduct.get();
//Product.setDescription(desc);
//Product.setPrice(price);
//Product.setproductname(name);
 Product.setDescription(dto.getDescription());
Product.setPrice(dto.getPrice());
Product.setproductname(dto.getProductname());
poductRepositry.save(Product);





    }

    public void delete(Integer id) {
        boolean exsits=poductRepositry.existsById(id);
        if(!exsits){
            throw new IllegalStateException("id"+id+" not exsits");
        }
        poductRepositry.deleteById(id);

    }
    public product getProduct(Integer productId){
        Optional<product> OptProduct=poductRepositry.findById(productId);
        if(!OptProduct.isPresent()){
            throw new IllegalStateException("product not found");

        }
        return OptProduct.get();

    }
}
