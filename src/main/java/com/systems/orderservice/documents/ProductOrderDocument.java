package com.systems.orderservice.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_order")
public class ProductOrderDocument {
    @Id
    private String id;
    @DBRef
    private CustomerOrderDocument customerOrderId;
    private String productId;
    private Integer quantity;
    private Double subTotal;

    public ProductOrderDocument(){
        //Default constructor for ORM
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerOrderDocument getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(CustomerOrderDocument customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}