package com.systems.orderservice.services.impl;

import com.systems.orderservice.commons.ObjectUtils;
import com.systems.orderservice.commons.ResponseEntity;
import com.systems.orderservice.documents.CustomerOrderDocument;
import com.systems.orderservice.documents.ProductOrderDocument;
import com.systems.orderservice.dtos.*;
import com.systems.orderservice.repositories.CustomerOrderRepository;
import com.systems.orderservice.repositories.ProductOrderRepository;
import com.systems.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Override
    public ResponseEntity<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {
        AddOrderResponse addOrderResponse = new AddOrderResponse();

        // get Customer by customerId
        ParameterizedTypeReference<ResponseEntity<Customer>> customerResponseType = new ParameterizedTypeReference<ResponseEntity<Customer>>() {};
        org.springframework.http.ResponseEntity<ResponseEntity<Customer>> customerDocument = restTemplate.exchange(
                "http://localhost:8082/customers/" + addOrderRequest.getCustomer().getId(),
                HttpMethod.GET,
                null,
                customerResponseType
        );

        if(!ObjectUtils.isNull(customerDocument.getBody().getData())){
            //set Shipment Information
            ShipmentInformation shipmentInformation = new ShipmentInformation();
            shipmentInformation.setMobile(addOrderRequest.getCustomer().getMobile());
            shipmentInformation.setLandline(addOrderRequest.getCustomer().getLandline());
            shipmentInformation.setCountry(addOrderRequest.getCustomer().getCountry());
            shipmentInformation.setCity(addOrderRequest.getCustomer().getCity());
            shipmentInformation.setAddress(addOrderRequest.getCustomer().getAddress());

            //save CustomerOrder document
            CustomerOrderDocument customerOrderDocument = new CustomerOrderDocument();
            customerOrderDocument.setCustomerId(customerDocument.getBody().getData().getId());
            customerOrderDocument.setShipmentInformation(shipmentInformation);
            customerOrderDocument.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
            customerOrderDocument = customerOrderRepository.save(customerOrderDocument);

            for(AddOrderRequest.Product product : addOrderRequest.getProducts()){
                //get Product by productId
                ParameterizedTypeReference<ResponseEntity<Product>> responseType = new ParameterizedTypeReference<ResponseEntity<Product>>() {};
                org.springframework.http.ResponseEntity<ResponseEntity<Product>> productDocument = restTemplate.exchange(
                        "http://localhost:8081/products/" + product.getId(),
                        HttpMethod.GET,
                        null,
                        responseType
                );
                if(!ObjectUtils.isNull(productDocument)){
                    ProductOrderDocument productOrderDocument = new ProductOrderDocument();
                    productOrderDocument.setCustomerOrderId(customerOrderDocument);
                    productOrderDocument.setProductId(productDocument.getBody().getData().getProductId());
                    productOrderDocument.setQuantity(product.getQuantity());
                    productOrderDocument.setSubTotal(product.getQuantity()*productDocument.getBody().getData().getProductPrice());
                    productOrderRepository.save(productOrderDocument);
                }
            }

            addOrderResponse.setOrderId(customerOrderDocument.getId());
        }
        return ResponseEntity.ok(addOrderResponse, "Your order has been received.");
    }
}