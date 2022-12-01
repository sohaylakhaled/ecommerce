package com.example.demo.dto;

public class productlineviewdto {
private Integer Id;
    public double getTotalprice() {
        return totalprice;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    private double totalprice;
    private int productquantity;


}
