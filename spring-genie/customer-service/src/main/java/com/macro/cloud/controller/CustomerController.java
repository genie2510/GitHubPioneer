package com.macro.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import cn.hutool.core.util.StrUtil;
import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.Customer;
import com.macro.cloud.service.CustomerService;

/**
 * @auther macrozheng
 * @description 用户管理Controller
 * @date 2023/11/30
 * @github https://github.com/macrozheng
 */
@RestController
@RequestMapping("/customer-service/customer")
public class CustomerController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Customer user) {
        userService.create(user);
        return new CommonResult("操作成功", 200);
    }

    @GetMapping("/{id}")
    public CommonResult<Customer> getUser(@PathVariable Long id) {
    	Customer user = userService.getUser(id);
        System.out.println("根据id获取用户信息，用户名称为： "+user.getUsername());
        LOGGER.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        String serviceId = request.getHeader("X-ServiceId");
//        if (StrUtil.isNotEmpty(serviceId)) {
//            LOGGER.info("获取到自定义请求头:X-ServiceId={}", serviceId);
//        }
        return new CommonResult<>(user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<Customer>> getUserByIds(@RequestParam List<Long> ids) {
        List<Customer> userList= userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}",userList);
        return new CommonResult<>(userList);
    }

    @GetMapping("/getByUsername")
    public CommonResult<Customer> getByUsername(@RequestParam String username) {
    	Customer user = userService.getByUsername(username);
        return new CommonResult<>(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody Customer user) {
        userService.update(user);
        return new CommonResult("操作成功", 200);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        userService.delete(id);
        return new CommonResult("操作成功", 200);
    }
}
