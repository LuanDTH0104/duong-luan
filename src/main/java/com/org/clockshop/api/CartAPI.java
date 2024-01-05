package com.org.clockshop.api;

import com.org.clockshop.DTO.CartItemDTO;
import com.org.clockshop.model.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CartAPI {

    private static final String CART_SESSION = "cart";
    @GetMapping(value = {"", "/"})
    public List<CartItemDTO> getCart(HttpSession httpSession) {
        Object cartSession = httpSession.getAttribute(CART_SESSION);
        if (cartSession == null) {
            return Collections.EMPTY_LIST;
        }
        return (List<CartItemDTO>) cartSession;
    }
}
