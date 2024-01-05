package com.org.clockshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "user",schema = "dbo")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_account")
    private String userAccount;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_create_time")
    private String createTime;

    @Column(name = "user_deleted")
    private boolean userDeleted;
}
