package com.macro.cloud.service;

import java.util.List;

import com.macro.cloud.domain.Product;

/**
 * @auther macrozheng
 * @description 用户管理Service
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
public interface ProductService {
    void create(Product user);

    Product getUser(Long id);

    void update(Product user);

    void delete(Long id);

    Product getByUsername(String username);

    List<Product> getUserByIds(List<Long> ids);
}
