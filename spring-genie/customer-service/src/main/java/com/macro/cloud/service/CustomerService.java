package com.macro.cloud.service;

import java.util.List;

import com.macro.cloud.domain.Customer;

/**
 * @auther macrozheng
 * @description 用户管理Service
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
public interface CustomerService {
    void create(Customer user);

    Customer getUser(Long id);

    void update(Customer user);

    void delete(Long id);

    Customer getByUsername(String username);

    List<Customer> getUserByIds(List<Long> ids);
}
