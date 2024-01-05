package com.org.clockshop.service;

import com.org.clockshop.model.Address;
import com.org.clockshop.model.OrderDetail;
import com.org.clockshop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    int insertOrder(int userId, List<OrderDetail> lstOrderDetail, Address address, String description, String paymentMethod);
}
