package com.example.demo.dto;

import com.example.demo.classes.product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductLinedto {
    public ProductLinedto() {
    }
    private int productquantity;

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }



  private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
