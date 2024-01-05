package com.org.clockshop.controller;

import com.org.clockshop.DTO.CartItemDTO;
import com.org.clockshop.model.Product;
import com.org.clockshop.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String CART_SESSION = "cart";

    @Autowired
    private ProductService productService;

    @GetMapping("/add-to-card/{id}/{quantity}")
    public String addToCard(@PathVariable("id") String productId,@PathVariable("quantity") String quantity, HttpSession httpSession){
        try {
            Product product = productService.getByProductId(Integer.parseInt(productId));
            CartItemDTO cartItemDTO = new CartItemDTO(
                    product.getProductId(),
                    product.getProductName(),
                    product.getProductImgUrl(),
                    product.getPrice(),
                    Integer.parseInt(quantity),
                    product.getDescription()
            );

            Object cart = httpSession.getAttribute(CART_SESSION);
            List<CartItemDTO> lstCard;
            if (cart == null){
                lstCard = new ArrayList<>();
                lstCard.add(cartItemDTO);
            }else{
                lstCard = (List<CartItemDTO>)cart;

                boolean isExist = false;
                for (CartItemDTO itemDTO : lstCard){
                    if (itemDTO.getProductId() == cartItemDTO.getProductId()){
                        itemDTO.setQuantity(itemDTO.getQuantity() + cartItemDTO.getQuantity());
                        isExist = true;
                        break;
                    }
                }

                if(!isExist){
                    lstCard.add(cartItemDTO);
                }
            }
            for (CartItemDTO itemDTO : lstCard){
                System.out.println(itemDTO.getProductId() + " | " + itemDTO.getQuantity());
            }
            httpSession.setAttribute(CART_SESSION,lstCard);
        }catch (Exception ignored){}

        return "redirect:/product";
    }

    @GetMapping("/checkout")
    public String getCheckOut(){
        return "checkout";
    }



}
