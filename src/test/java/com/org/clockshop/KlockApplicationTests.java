package com.org.clockshop;

import com.org.clockshop.model.Address;
import com.org.clockshop.model.OrderDetail;
import com.org.clockshop.model.Role;
import com.org.clockshop.repository.RoleRepository;
import com.org.clockshop.repository.UserRepository;
import com.org.clockshop.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class KlockApplicationTests {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        for (Role role : roleRepository.getRoleByUserAccount("dangch")) {
            System.out.println(role.getRoleName());
        }
        System.out.println("ádjhddddddddddddddddddddddddddddddddddddddddddddddddddđ");
    }

    @Test
    void load() {
        System.out.println(userRepository.getUserByUserAccount("dangch").getUserAccount());
    }

    @Test
    void insertNewOrder(){
        int userId = 5;

        OrderDetail orderDetail1 = new OrderDetail(1, 5);

        OrderDetail orderDetail2 = new OrderDetail(2, 10);

        OrderDetail orderDetail3 = new OrderDetail(3, 2);

        OrderDetail orderDetail4 = new OrderDetail(4, 8);

        OrderDetail orderDetail5 = new OrderDetail(5, 3);

        List<OrderDetail> lstOrderDetail = new ArrayList<>();

        lstOrderDetail.add(orderDetail1);
        lstOrderDetail.add(orderDetail2);
        lstOrderDetail.add(orderDetail3);
        lstOrderDetail.add(orderDetail4);
        lstOrderDetail.add(orderDetail5);

        Address address = new Address();

        // Thiết lập các thuộc tính cho đối tượng Address
        address.setUserId(userId);
        address.setAddressName("123 Main Street");
        address.setReceiverName("John Doe");
        address.setReceiverPhone("555-1234");
        address.setIsDefault(true);

        orderService.insertOrder(userId,lstOrderDetail,address,"des","method");
    }
}
