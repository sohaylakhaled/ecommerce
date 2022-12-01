package com.example.demo.classes;

import javax.persistence.*;

@Entity
@Table
public class product {
    @Id
    @SequenceGenerator(
            name = "Customer_sequence",
            sequenceName = "Customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Customer_sequence"
    )
    private Integer id;
    private String productname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String description;
    private int price;
}
