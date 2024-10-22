package com.macro.cloud.service;

import com.macro.cloud.domain.User;

import java.util.List;

/**
 * @auther macrozheng
 * @description 用户管理Service
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
public interface UserService {
    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
