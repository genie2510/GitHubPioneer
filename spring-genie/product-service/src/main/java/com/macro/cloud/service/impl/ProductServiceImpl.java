package com.macro.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.macro.cloud.domain.Product;
import com.macro.cloud.service.ProductService;

import jakarta.annotation.PostConstruct;

/**
 * @auther macrozheng
 * @description 用户管理Service实现类
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> productList;

    @Override
    public void create(Product user) {
        productList.add(user);
    }

    @Override
    public Product getUser(Long id) {
        List<Product> findUserList = productList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public void update(Product user) {
        productList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
            userItem.setUsername(user.getUsername());
            userItem.setPassword(user.getPassword());
        });
    }

    @Override
    public void delete(Long id) {
    	Product user = getUser(id);
        if (user != null) {
            productList.remove(user);
        }
    }

    @Override
    public Product getByUsername(String username) {
        List<Product> findUserList = productList.stream().filter(userItem -> userItem.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public List<Product> getUserByIds(List<Long> ids) {
        return productList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }

    @PostConstruct
    public void initData() {
        productList = new ArrayList<>();
        productList.add(new Product(1L, "macro", "123456"));
        productList.add(new Product(2L, "andy", "123456"));
        productList.add(new Product(3L, "mark", "123456"));
    }
}
