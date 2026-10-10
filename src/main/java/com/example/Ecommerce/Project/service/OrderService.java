package com.example.Ecommerce.Project.service;

import com.example.Ecommerce.Project.dto.CreateOrderRequest;
import com.example.Ecommerce.Project.dto.OrderCreated;
import com.example.Ecommerce.Project.dto.OrderItemDto;
import com.example.Ecommerce.Project.entity.Order;
import com.example.Ecommerce.Project.entity.OrderItem;
import com.example.Ecommerce.Project.entity.Product;
import com.example.Ecommerce.Project.repository.OrderRepository;
import com.example.Ecommerce.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private OrderRepository orderRepo;

    public OrderCreated createOrder(CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemsAmount = 0;


        for(OrderItemDto item: orderRequest.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = prodRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice() * item.getQuantity();

            order.getOrderItems().add(orderItem);

        }

        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount = 0;
        double taxAmount = 10;
        totalAmount = totalItemsAmount  + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
        String refId = UUID.randomUUID().toString();
        order.setReferenceId(refId);
        orderRepo.save(order);
        return new OrderCreated(refId);

    }

    public Order getOrder(String referenceId) {
        // TODO Auto-generated method stub
        return orderRepo.findByReferenceId(referenceId).orElseThrow(() -> new RuntimeException("No order found with Ref Id"));
    }
}
