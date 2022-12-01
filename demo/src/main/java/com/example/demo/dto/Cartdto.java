package com.example.demo.dto;

public class Cartdto {
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getQuantityOfProductline() {
        return QuantityOfProductline;
    }

    public void setQuantityOfProductline(int quantityOfProductline) {
        QuantityOfProductline = quantityOfProductline;
    }

    private double totalprice;
    private int QuantityOfProductline;

}
