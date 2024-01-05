package com.org.clockshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@ToString
public class CustomUser extends User implements Serializable {

    private int id;
    private String userCreateTime;
    private boolean userDeleted;

    public CustomUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            int id,
            String userCreateTime,
            boolean userDeleted) {
        super(username, password, authorities);
        this.id = id;
        this.userCreateTime = userCreateTime;
        this.userDeleted = userDeleted;
    }

}
