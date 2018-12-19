package com.aws.springboot_mybatis.modules.user.controller;

import com.aws.springboot_mybatis.modules.user.dto.UserDTO;
import com.aws.springboot_mybatis.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping("/get/{user_id}")
    public UserDTO getUserById(@PathVariable String user_id){
        return userService.getUserById(user_id);
    }

    @ResponseBody
    @PutMapping("/insert")
    public void insertUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
    }

    @ResponseBody
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }

    @ResponseBody
    @DeleteMapping("/delete/{user_id}")
    public void deleteUser(@PathVariable String user_id){
        userService.deleteUser(user_id);
    }

    @GetMapping("/page")
    public String getUserPage(){
        return "userpage";
    }
}
