package com.macro.cloud.domain;

/**
 * @auther macrozheng
 * @description 用户信息封装
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
public class Customer {

    private Long id;
    private String customername;
    private String password;

    public Customer() {
    }

    public Customer(Long id, String username, String password) {
        this.id = id;
        this.customername = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return customername;
    }

    public void setUsername(String username) {
        this.customername = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
