package com.macro.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.macro.cloud.domain.Customer;
import com.macro.cloud.service.CustomerService;

import jakarta.annotation.PostConstruct;

/**
 * @auther macrozheng
 * @description 用户管理Service实现类
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customerList;

    @Override
    public void create(Customer user) {
        customerList.add(user);
    }

    @Override
    public Customer getUser(Long id) {
        List<Customer> findUserList = customerList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public void update(Customer user) {
        customerList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
            userItem.setUsername(user.getUsername());
            userItem.setPassword(user.getPassword());
        });
    }

    @Override
    public void delete(Long id) {
    	Customer user = getUser(id);
        if (user != null) {
            customerList.remove(user);
        }
    }

    @Override
    public Customer getByUsername(String username) {
        List<Customer> findUserList = customerList.stream().filter(userItem -> userItem.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public List<Customer> getUserByIds(List<Long> ids) {
        return customerList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }

    @PostConstruct
    public void initData() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1L, "TATA", "123456"));
        customerList.add(new Customer(2L, "HONDA", "78910"));
        customerList.add(new Customer(3L, "MAHINDRA", "11121314"));
    }
}
