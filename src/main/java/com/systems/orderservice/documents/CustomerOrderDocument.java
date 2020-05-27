package com.systems.orderservice.documents;

import com.systems.orderservice.dtos.ShipmentInformation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "customer_order")
public class CustomerOrderDocument {
    @Id
    private String id;
    private String customerId;
    private ShipmentInformation shipmentInformation;
    private Timestamp createDateTime;

    public CustomerOrderDocument(){
        //Default constructor for ORM
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ShipmentInformation getShipmentInformation() {
        return shipmentInformation;
    }

    public void setShipmentInformation(ShipmentInformation shipmentInformation) {
        this.shipmentInformation = shipmentInformation;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }
}
