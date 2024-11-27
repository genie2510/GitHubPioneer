package com.macro.cloud.domain;

/**
 * @auther macrozheng
 * @description 用户信息封装
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
public class Product {

    private Long id;
    private String productname;
    private String password;

    public Product() {
    }

    public Product(Long id, String productname, String password) {
        this.id = id;
        this.productname = productname;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return productname;
    }

    public void setUsername(String username) {
        this.productname = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
