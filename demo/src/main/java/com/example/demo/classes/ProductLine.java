package com.example.demo.classes;

import javax.persistence.*;

@Entity
@Table
public class ProductLine {


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
    @Column(name = "id", nullable = false)
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private int productquantity;

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;

    }

    public double getTotalprice() {
        return getProductquantity()*product.getPrice();
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    private double totalprice;
    @OneToOne
    @JoinColumn(name = "product_id")
    product product = new product();

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    public ProductLine(Integer id, int productquantity, double totalprice, com.example.demo.classes.product product) {
        this.id = id;
        this.productquantity = productquantity;
        this.totalprice = totalprice;
        this.product = product;
    }

    public ProductLine() {
    }

}
