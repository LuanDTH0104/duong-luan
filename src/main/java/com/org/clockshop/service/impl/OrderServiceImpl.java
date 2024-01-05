package com.org.clockshop.service.impl;

import com.org.clockshop.model.*;
import com.org.clockshop.repository.AddressHistoryRepository;
import com.org.clockshop.repository.OrderDetailRepository;
import com.org.clockshop.repository.OrderRepository;
import com.org.clockshop.repository.ProductRepository;
import com.org.clockshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(propagation =  Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {


    OrderRepository orderRepository;
    OrderDetailRepository orderDetailRepository;
    AddressHistoryRepository addressHistoryRepository;
    ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, AddressHistoryRepository addressHistoryRepository,ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.addressHistoryRepository = addressHistoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public int insertOrder(int userId, List<OrderDetail> lstOrderDetail, Address address, String description, String paymentMethod) {
        AddressHistory addressHistory = new AddressHistory(address.getReceiverName(),address.getReceiverPhone(),address.getAddressName());

        int addressHistoryId = addressHistoryRepository.save(addressHistory).getAddressHisId();

        Order order = new Order(
                userId,
                addressHistoryId,
                LocalDate.now().toString(),
                description,
                paymentMethod
                );

        int orderId = orderRepository.save(order).getOrderId();

        lstOrderDetail.forEach(item -> {
            item.setOrderId(orderId);

            Product product = productRepository.getByProductId(item.getProductId());

            item.setProductPrice(product.getPrice());
            item.setProductName(product.getProductName());

            orderDetailRepository.save(item);
        });

        return 0;
    }
}
