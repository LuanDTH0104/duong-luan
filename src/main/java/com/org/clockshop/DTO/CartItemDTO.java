package com.org.clockshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO implements Serializable {
    private int productId;
    private String productName;
    private String productImgUrl;
    private Float price;
    private Integer quantity;
    private String description;

}
