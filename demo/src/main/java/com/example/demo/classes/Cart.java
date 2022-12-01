package com.example.demo.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cart {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    private long id;
    @OneToMany
    @JoinColumn(name = "itemLine_idd")
   private List<ProductLine> productLineList;


    private double totalprice;
    private int QuantityOfProductline;

    public List<ProductLine> getProductLineList() {
        return productLineList;
    }

    public void setProductLineList(List<ProductLine> productLineList) {
        this.productLineList = productLineList;

    }

    public double getTotalprice() {
        for (ProductLine productLine:productLineList){
            totalprice+=productLine.getTotalprice();
        }
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getQuantityOfProductline() {

        return QuantityOfProductline=productLineList.size();

    }

    public void setQuantityOfProductline(int quantityOfProductline) {
        QuantityOfProductline = quantityOfProductline;
    }
}
